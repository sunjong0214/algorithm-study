import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] isVisited;
    static int[][] apt;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        apt = new int[n][n];
        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                apt[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (apt[i][j] == 1 && !isVisited[i][j]) {
                    q.offer(new int[]{i, j});
                    isVisited[i][j] = true;
                    int cnt = 1;
                    while (!q.isEmpty()) {
                        int qX = q.peek()[0];
                        int qY = q.poll()[1];
                        for (int k = 0; k < 4; k++) {
                            int dX = qX + dx[k];
                            int dY = qY + dy[k];
                            if (dX < 0 || dX >= n || dY < 0 || dY >= n) continue;
                            if (isVisited[dX][dY]) continue;
                            if (apt[dX][dY] == 0) continue;
                            q.offer(new int[]{dX, dY});
                            isVisited[dX][dY] = true;
                            cnt++;
                        }
                    }
                    list.add(cnt);
                }
            }
        }

        list.sort((a, b) -> a - b);

        bw.write(list.size() + "\n");
        for (int num : list) {
            bw.write(num + "\n");
        }
        br.close();
        bw.close();
    }
}
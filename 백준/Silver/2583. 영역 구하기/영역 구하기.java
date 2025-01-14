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
    static int[][] arr;
    static boolean[][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for (int z = startY; z < endY; z++) {
                for (int j = startX; j < endX; j++) {
                    arr[z][j] = -1;
                    isVisited[z][j] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int resultIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    q.isEmpty();
                    q.add(new int[]{i, j});
                    arr[i][j] = 1;
                    isVisited[i][j] = true;
                    result.add(1);
                    while (!q.isEmpty()) {
                        int x = q.peek()[0];
                        int y = q.poll()[1];
                        for (int z = 0; z < 4; z++) {
                            int dX = x + dx[z];
                            int dY = y + dy[z];
                            if (dX < 0 || dX >= n || dY < 0 || dY >= m) {
                                continue;
                            }
                            if (isVisited[dX][dY]) {
                                continue;
                            }
                            q.offer(new int[]{dX, dY});
                            isVisited[dX][dY] = true;
                            arr[dX][dY] = 1;
                            result.add(resultIdx, result.remove(resultIdx) + 1);
                        }
                    }
                    resultIdx++;
                }
            }
        }
        result.sort((a, b) -> a - b);

        bw.write(resultIdx + "\n");
        for (int num : result) {
            bw.write(num + " ");
        }
        br.close();
        bw.close();
    }
}
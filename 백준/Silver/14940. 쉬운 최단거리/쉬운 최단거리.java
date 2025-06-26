import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] isVisit;
    static Queue<int[]> q;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        arr = new int[n][m];
        isVisit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    isVisit[i][j] = true;
                }
            }
        }

        //bfs
        int[][] result = new int[n][m];
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0], y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (isVisit[nx][ny]) {
                    continue;
                }
                if (arr[nx][ny] == 0) {
                    continue;
                }

                result[nx][ny] = result[x][y] + 1;
                q.offer(new int[]{nx, ny});
                isVisit[nx][ny] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0 && arr[i][j] == 1) {
                    bw.write(-1 + " ");
                } else {
                    bw.write(result[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
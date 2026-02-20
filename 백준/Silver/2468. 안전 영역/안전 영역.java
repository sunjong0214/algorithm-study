import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(arr[i][j], maxHeight);
            }
        }

        int maxCnt = 0;
        for (int height = 1; height <= maxHeight; height++) {
            int cnt = 0;
            q.clear();
            boolean[][] isVisited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] >= height && !isVisited[i][j]) {     
                        cnt++;
                        q.offer(new int[] {i, j});
                        isVisited[i][j] = true;
                        while (!q.isEmpty()) {
                            int[] p = q.poll();
                            for (int z = 0; z < 4; z++) {
                                int nx = p[0] + dx[z];
                                int ny = p[1] + dy[z];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                                if (isVisited[nx][ny]) continue;
                                if (arr[nx][ny] < height) continue;
                                q.offer(new int[] {nx, ny});
                                isVisited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }

        bw.write(maxCnt + "");
        br.close();
        bw.close();
    }
}
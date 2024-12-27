import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] arr = new int[size][size];
            boolean[][] isV = new boolean[size][size];
            Queue<int[]> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            q.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            st = new StringTokenizer(br.readLine());
            int[] dest = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            isV[q.peek()[0]][q.peek()[1]] = true;
            while (!q.isEmpty()) {
                int qX = q.peek()[0];
                int qY = q.poll()[1];
                if (qX == dest[0] && qY == dest[1]) {
                    bw.write(arr[qX][qY] + "\n");
                    break;
                }
                for (int k = 0; k < 8; k++) {
                    int nx = qX + dx[k];
                    int ny = qY + dy[k];
                    if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                    if (isV[nx][ny]) continue;
                    arr[nx][ny] = arr[qX][qY] + 1;
                    q.offer(new int[] {nx, ny});
                    isV[nx][ny] = true;
                }
            }
        }
        br.close();
        bw.close();
    }
}
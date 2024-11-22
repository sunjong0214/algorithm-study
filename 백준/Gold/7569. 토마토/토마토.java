import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int x;
    static int y;
    static int z;
    static int[][] arr;
    static boolean[][] isVisited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());
        arr = new int[y * z][x];
        isVisited = new boolean[y * z][x];
        for (int i = 0; i < y * z; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
                if (arr[i][j] == -1) {
                    isVisited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int qy = poll[0];
            int qx = poll[1];
            int yPoint = qy / y * y;
            for (int i = 0; i < 4; i++) {
                int tx = qx + dx[i];
                int ty = qy + dy[i];
                if (tx < 0 || tx >= x || ty < yPoint || ty >= yPoint + y) {
                    continue;
                }
                if (isVisited[ty][tx]) {
                    continue;
                }
                queue.add(new int[]{ty, tx});
                isVisited[ty][tx] = true;
                arr[ty][tx] = arr[qy][qx] + 1;
            }
            if (qy - y >= 0 && !isVisited[qy - y][qx]) {
                queue.add(new int[]{qy - y, qx});
                isVisited[qy - y][qx] = true;
                arr[qy - y][qx] = arr[qy][qx] + 1;
            }
            if (qy + y < y * z && !isVisited[qy + y][qx]) {
                queue.add(new int[]{qy + y, qx});
                isVisited[qy + y][qx] = true;
                arr[qy + y][qx] = arr[qy][qx] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < y * z; i++) {
            for (int j = 0; j < x; j++) {
                result = Math.max(result, arr[i][j]);
            }
        }
        result -= 1;
        for (int i = 0; i < y * z; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j] == 0) {
                    result = -1;
                    break;
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
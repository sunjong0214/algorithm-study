import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        bw.write(dfs(0, 0) + "");
        br.close();
        bw.close();
    }

    static int dfs(int i, int j) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int zX = i + dx[k];
            int zY = j + dy[k];
            if (zX < 0 || zX >= n || zY < 0 || zY >= m) {
                continue;
            }
            if (arr[zX][zY] < arr[i][j]) {
                dp[i][j] += dfs(zX, zY);
            }
        }
        return dp[i][j];
    }
}
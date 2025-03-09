import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 갯수
        m = Integer.parseInt(st.nextToken()); // 구간 수
        arr = new int[n + 1];
        dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(br.readLine());
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = -32768 * 101;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                int num = 0;
                if (j == 1) {
                    num = -1;
                }
                for (int k = i - 2; k >= num; k--) {
                    if (k < 0) {
                        dp[i][j] = Math.max(dp[i][j], arr[i]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + arr[i] - arr[k + 1]);
                    }
                }
            }
        }
        bw.write(dp[n][m] + "\n");
        br.close();
        bw.close();
    }
}
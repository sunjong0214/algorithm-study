import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int n;
    static int k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= (i + 1) / 2; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % 1_000_000_003;
            }
        }

        bw.write((dp[n - 3][k - 1] + dp[n - 1][k]) % 1_000_000_003 + "");
        br.close();
        bw.close();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    // static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dp = new int[n + 1][m + 1];

            Arrays.fill(dp[0], 1);
            // dp[i] = dp[i - 1][j - 1]
            // 남은 다리가 있을 때, n 이상 갈 수는 없다 
            for (int i = 1; i <= n; i++) {
                dp[i][i] = 1;
                for (int j = i + 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    // System.out.println(dp[i][j]);
                }
            }
            bw.write(String.valueOf(dp[n][m]) + "\n");
        }
        br.close();
        bw.close();
    }
}
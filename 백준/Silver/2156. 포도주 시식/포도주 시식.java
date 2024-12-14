import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = seq[0];
        dp[0][1] = seq[0];
        dp[0][2] = 0;

        int m = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1] + seq[i];
            dp[i][1] = dp[i - 1][2] + seq[i];
            dp[i][2] = Math.max(m, Math.max(dp[i - 1][0], dp[i - 1][1]));
            m = dp[i][2];
        }

        int max = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));

        bw.write(max + "");
        br.close();
        bw.close();
    }
}
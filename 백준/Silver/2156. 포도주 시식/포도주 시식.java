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

        int[] seq = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = seq[1];
        if (n != 1) {
            dp[2] = Math.max(dp[1], Math.max(dp[1] + seq[2], dp[0] + seq[2]));
            for (int i = 3; i < n + 1; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + seq[i], dp[i - 3] + seq[i - 1] + seq[i]));
            }
        }

        bw.write(dp[n] + "");
        br.close();
        bw.close();
    }
}
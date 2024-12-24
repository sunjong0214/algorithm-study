import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        if (n > 0) {
            dp = new int[n + 1];
            bw.write("1" + "\n");
            dp[1] = 1;
            if (n != 1) {
                for (int i = 2; i <= n; i++) {
                    dp[i] = dp[i - 1] % 1000000000 + dp[i - 2] % 1000000000;
                }
            }
            bw.write(dp[n] % 1000000000 + "");
        } else if (n == 0) {
            bw.write("0" + "\n");
            bw.write(0 + "");
        } else {
            n = Math.abs(n);
            dp = new int[n + 1];
            dp[1] = 1;
            if (n != 1) {
                dp[2] = -1;
                for (int i = 3; i <= n; i++) {
                    dp[i] = dp[i - 2] % 1000000000 - dp[i - 1] % 1000000000;
                }
            }
            if (dp[n] > 0) {
                bw.write("1" + "\n");
            } else bw.write("-1" + "\n");
            bw.write(Math.abs(dp[n] % 1000000000) + "");
        }

        br.close();
        bw.close();
    }
}
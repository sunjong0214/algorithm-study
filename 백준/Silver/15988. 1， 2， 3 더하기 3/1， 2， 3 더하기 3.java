import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N, t;
    static long[] dp = new long[1000001];
    static int mod = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        int recent = 3;
        for (int i = 0; i < t; i++) {
            N = Integer.parseInt(br.readLine());
            if (N <= 2) {
                bw.write(N + "\n");
            } else {
                dp[0] = 1;
                dp[1] = 1;
                dp[2] = 2;
                if (dp[N] == 0) {
                    for (int j = recent; j <= N; j++) {
                        dp[j] = dp[j - 1] % mod + dp[j - 2] % mod + dp[j - 3] % mod;
                    }
                    recent = Math.max(recent, N);
                }
                bw.write(dp[N] % mod + "\n");
            }
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
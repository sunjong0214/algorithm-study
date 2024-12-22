import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[n][i] = 10 - i;
        }

        for (int i = n - 1; i > 0; i--) {
            func(i, 0);
        }
        bw.write( dp[1][0] % 10007 + "");
        br.close();
        bw.close();
    }

    private static long func(int digit, int num) {
        if (dp[digit][num] != 0) {
            return dp[digit][num] % 10007;
        }
        for (int i = num; i < 10; i++) {
            dp[digit][num] = dp[digit][num] % 10007 + func(digit + 1, i) % 10007;
        }
        return dp[digit][num] % 10007;
    }
}
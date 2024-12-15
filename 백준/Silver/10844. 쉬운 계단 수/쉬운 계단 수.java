import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int n;
    static long result;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        long result = 0;
        for (int i = 1; i <= 9; i++) {
            result += func(i, n);
        }

        bw.write(result % 1000000000 + "");
        br.close();
        bw.close();
    }

    private static long func(int num, int idx) {
        if (idx == 1) {
            return dp[idx][num];
        }
        if (dp[idx][num] == 0) {
            if (num == 0) {
                dp[idx][num] = func(1, idx - 1);
            } else if (num == 9) {
                dp[idx][num] = func(8, idx - 1);
            } else {
                dp[idx][num] = func(num + 1, idx - 1) + func(num - 1, idx - 1);
            }
        }
        return dp[idx][num] % 1000000000;
    }
}
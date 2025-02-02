import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int n;
    static int mod = 1000000000;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[10][n + 1];

        for (int i = 1; i <= 9; i++) {
            result += func(i, 1) % mod;
        }
        bw.write(String.valueOf(result % mod));
        br.close();
        bw.close();
    }

    private static int func(int num, int idx) {
        if (idx == n) {
            return 1;
        }
        if (dp[num][idx] != 0) {
            return dp[num][idx] % mod;
        }
        if (num == 0) {
            dp[num][idx] = func(1, idx + 1);
        } else if (num == 9) {
            dp[num][idx] = func(8, idx + 1);
        } else {
            dp[num][idx] = func(num - 1, idx + 1) + func(num + 1, idx + 1);
        }
        return dp[num][idx] % mod;
    }
}
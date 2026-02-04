import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[5001];
 
        Arrays.fill(dp, Integer.MAX_VALUE);
        int r = func(n, 0);
        if (r == Integer.MAX_VALUE) bw.write(String.valueOf(-1));
        else bw.write(String.valueOf(r));
        br.close();
        bw.close();
    }

    static int func(int n, int cnt) {
        if (dp[n] != Integer.MAX_VALUE) return dp[n];
        if (n == 0) return cnt;
        if (n < 3) return Integer.MAX_VALUE;
        if (n >= 5) dp[n] = Math.min(dp[n], func(n - 5, cnt + 1));
        if (n >= 3) dp[n] = Math.min(dp[n], func(n - 3, cnt + 1));
        return dp[n];
    }
}
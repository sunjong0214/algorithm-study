import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        for (int i = 1; i <= n; i++) {
            func(i);
        }

        bw.write(dp[n] + "");
        br.close();
        bw.close();
    }

    private static long func(int amount) {
        if (amount == n + 1 || dp[amount] != 0) {
            return dp[amount];
        }
        for (int i = amount / 2; i < amount; i++) {
            dp[amount] = Math.max(arr[amount], Math.max(func(i) + func(amount - i), dp[amount]));
        }
        return dp[amount];
    }
}
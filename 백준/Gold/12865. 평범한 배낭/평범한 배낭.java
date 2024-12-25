import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int[] amount;
    static int[] weight;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        amount = new int[n];
        weight = new int[n];
        dp = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            amount[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(func(n - 1, k) + "");
        br.close();
        bw.close();
    }

    private static long func(int i, int k) {
        if (i < 0) {
            return 0;
        }
        if (dp[i][k] == 0) {
            if (amount[i] > k) {
                dp[i][k] = func(i - 1, k);
            } else {
                dp[i][k] = Math.max(func(i - 1, k), func(i - 1, k - amount[i]) + weight[i]);
            }
        }
        return dp[i][k];
    }
}
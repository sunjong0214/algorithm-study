import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] cost, people;
    static int[] dp;
    static int c, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        cost = new int[n + 1];
        people = new int[n + 1];
        dp = new int[c + 101];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 987654321);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = people[i]; j < c + 101; j++) {
                dp[j] = Math.min(dp[j], cost[i] + dp[j - people[i]]);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = c; i < c + 101; i++) {
            result = Math.min(result, dp[i]);
        }
        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] date = new int[n + 1];
        int[] cost = new int[n + 1];
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            date[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= n; i++) {
            if (max < dp[i]) max = dp[i];
            int idx = i + date[i];
            if (idx > n) continue;
            dp[idx] = Math.max(max + cost[i], dp[idx]);
        }
        bw.write(max + "");
        br.close();
        bw.close();
    }
}

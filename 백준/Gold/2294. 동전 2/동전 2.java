import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] <= k) {
                dp[arr[i]] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = arr[j] + 1; i <= k; i++) {
                if (dp[i - arr[j]] == 0) {
                    continue;
                }
                if (dp[i] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                } else {
                    dp[i] = dp[i - arr[j]] + 1;
                }
            }
        }
        if (dp[k] == 0) {
            dp[k] = -1;
        }
        bw.write(dp[k] + "");
        br.close();
        bw.close();
    }
}
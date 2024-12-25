import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        while (true) {
            count++;
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            arr = new int[n + 1][3];
            dp = new long[n + 1][3];
            for (int i = 1; i < n + 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[1][0] = arr[1][1];
            dp[1][1] = arr[1][1];
            dp[1][2] = Math.min(arr[1][1] + arr[1][2], arr[1][1]);

            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][0]) + arr[i][0];
                dp[i][1] = Math.min(Math.min(dp[i - 1][1], Math.min(dp[i - 1][0], dp[i][0])), dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][1], dp[i][1])) + arr[i][2];
            }
            bw.write(count + ". " + dp[n][1] + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
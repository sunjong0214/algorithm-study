import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3];
        arr = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + arr[i][1];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]) + arr[i][2];
        }
        bw.write(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])) + " ");

        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][2];
        }
        bw.write(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])) + "");
        br.close();
        bw.close();
    }
}
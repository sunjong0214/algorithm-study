import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, arr1;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        arr1 = new int[n + 1];
        dp = new int[n + 1][101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr1[i] = Integer.parseInt(st1.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 100; j++) {
                if (arr[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], arr1[i] + dp[i - 1][j - arr[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        bw.write(dp[n][99] + "");
        br.close();
        bw.close();
    }
}
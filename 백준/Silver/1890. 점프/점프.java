import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long result;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[N][N] = 1;

        for (int i = N; i > 0; i--) {
            for (int j = N; j > 0; j--) {
                if (i == N && j == N) {
                    continue;
                }
                if (i + arr[i][j] <= N) {
                    dp[i][j] += dp[i + arr[i][j]][j];
                }
                if (j + arr[i][j] <= N) {
                    dp[i][j] += dp[i][j + arr[i][j]];
                }
            }
        }

        bw.write(dp[1][1] + "");
        br.close();
        bw.close();
    }
}
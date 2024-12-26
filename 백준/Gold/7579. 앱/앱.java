import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] M;
    static int[] C;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        M = new int[n + 1];
        C = new int[n + 1];
        dp = new long[n + 1][n * 101];
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= n; j++) {
            M[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= n; j++) {
            C[j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n * 101; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - C[j] < 0) {
                    dp[j][i] = dp[j - 1][i];
                } else {
                    dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - C[j]] + M[j]);
                }
                if (dp[j][i] >= m) {
                    bw.write(i + "");
                    bw.close();
                    br.close();
                    return;
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += C[i];
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
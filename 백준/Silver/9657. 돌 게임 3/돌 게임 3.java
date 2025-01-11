import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 2;
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0 && dp[i - 1] == 2) {
                dp[i] = 1;
            } else if (i - 3 >= 0 && dp[i - 3] == 2) {
                dp[i] = 1;
            } else if (i - 4 >= 0 && dp[i - 4] == 2) {
                dp[i] = 1;
            } else {
                dp[i] = 2;
            }
        }
        if (dp[n] == 1) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }
        br.close();
        bw.close();
    }
}
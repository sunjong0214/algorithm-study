import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[1] = 1;
        int num = 2;
        while (num * num <= n) {
            dp[num * num++] = 1;
        }
        num = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] != 0) {
                num++;
                continue;
            }
            dp[i] = dp[num * num] + dp[i - num * num];
            for (int j = num - 1; j >= 1; j--) {
                 dp[i] = Math.min(dp[j * j] + dp[i - j * j], dp[i]);
            }
        }
        bw.write(dp[n] + "");
        br.close();
        bw.close();
    }
}
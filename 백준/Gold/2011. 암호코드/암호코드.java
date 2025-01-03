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
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String seq = br.readLine();
        n = seq.length();
        arr = new int[n];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (seq.charAt(i - 1) == '0') {
                if (i == 1 || seq.charAt(i - 2) > '2' || seq.charAt(i - 2) == '0') {
                    dp[n] = 0;
                    break;
                }
            }
            if (i == 1) {
                dp[i] = 1;
                continue;
            }
            if (Integer.parseInt(seq.substring(i - 2, i)) > 26 || seq.charAt(i - 2) == '0') {
                dp[i] = dp[i - 1];
            } else if (seq.charAt(i - 1) == '0') {
                dp[i] = dp[i - 2];
                if (i == 2) {
                    dp[i]++;
                }
            }else {
                dp[i] = dp[i - 1] % 1000000 + dp[i - 2] % 1000000;
                if (i == 2 && seq.charAt(i - 1) != '0') {
                    dp[i]++;
                }
            }
        }
        bw.write(dp[n] % 1000000 + "");
        br.close();
        bw.close();
    }
}
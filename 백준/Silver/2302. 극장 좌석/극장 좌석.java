import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int n;
    static int m;
    static int[] vip;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        vip = new int[m + 2];

        dp[0] = 1;
        dp[1] = 1;
        vip[0] = 0;
        vip[m + 1] = n + 1;


        int result = 1;
        if (n == 1) {
            result = 0;
        }
        for (int i = 1; i <= m; i++) {
            vip[i] = Integer.parseInt(br.readLine());
            if (vip[i] != 0) {
                result *= func(vip[i] - vip[i - 1] - 1);
            }
            if (i == m) {
                result *= func(vip[i + 1] - vip[i] - 1);
            }
        }
        if (m == 0) {
            result = func(n);
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }

    private static int func(int count) {
        if (dp[count] != 0) {
            return dp[count];
        }
        dp[count] = func(count - 2) + func(count - 1);
        return dp[count];
    }
}
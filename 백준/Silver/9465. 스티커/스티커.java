import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int t;
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n + 1];
            dp = new int[2][n + 1];
            for (int k = 0; k < 2; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    dp[k][j] = -1;
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            func(0, n);
            func(1, n);
            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int func(int row, int column) {
        if (column == 1 || dp[row][column] != -1) {
            return dp[row][column];
        }
        dp[row][column] = Math.max(func(1- row, column - 1), func(1 - row, column - 2)) + arr[row][column];
        return dp[row][column];
    }
}
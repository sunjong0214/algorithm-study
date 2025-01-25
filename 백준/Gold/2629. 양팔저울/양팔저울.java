import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[][] dp;
    static int n, m, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new boolean[n + 1][40001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        knapsack(0, 0);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!dp[n][num]) {
                bw.write("N ");
            } else {
                bw.write("Y ");
            }
        }
        br.close();
        bw.close();
    }

    private static void knapsack(int num, int depth) {
        if (dp[depth][num]) {
            return;
        }
        dp[depth][num] = true;
        if (depth == n) {
            return;
        }
        knapsack(num, depth + 1);
        knapsack(Math.abs(num - arr[depth + 1]), depth + 1);
        knapsack(num + arr[depth + 1], depth + 1);
    }
}
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
    static int N;
    static int price;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N + 1];
            price = Integer.parseInt(br.readLine());
            dp = new int[price + 1];
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= N; j++) {
                for (int k = arr[j]; k <= price; k++) {
                    if (k - arr[j] <= 0) {
                        dp[k] = dp[k] + 1;
                    } else {
                        dp[k] = dp[k] + dp[k - arr[j]];
                    }
                }
            }
            bw.write(dp[price] + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
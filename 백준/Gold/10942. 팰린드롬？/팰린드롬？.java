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
    static int m;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n + 1][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (dp[s][e] == 0) {
                dp[s][e] = 2;
                if (e - s == 1 && arr[s - 1] != arr[e - 1]) {
                    dp[s][e] = 1;
                }
                for (int j = 0; j < e - s - 1; j++) {
                    if (arr[s + j - 1] != arr[e - j - 1]) {
                        dp[s][e] = 1;
                        break;
                    }
                }
            }
            bw.write(dp[s][e] - 1 + "\n");
        }
        br.close();
        bw.close();
    }
}
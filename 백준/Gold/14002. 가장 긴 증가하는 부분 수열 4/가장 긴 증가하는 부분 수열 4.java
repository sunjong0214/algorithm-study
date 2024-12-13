import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] seq = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int size = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i -1 ; j >= 0; j--) {
                if (seq[i] > seq[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    size = Math.max(size, dp[i]);
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        bw.write(size + "\n");
        for (int i = n; i > 0; i--) {
            if (dp[i] == size) {
                stack.push(seq[i]);
                size--;
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        br.close();
        bw.close();
    }
}
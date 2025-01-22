import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            int idx = i * 2;
            while (idx <= n) {
                arr[idx] = 1;
                idx += i;
            }
        }

        int sum = 0;
        int result = 0;
        int end = 2;
        for (int st = 2; st <= n; st++) {
            while (sum > n) {
                if (arr[end] == 0) {
                    sum -= end;
                }
                end++;
            }
            if (arr[st] == 0) {
                if (sum == n) {
                    result++;
                }
                sum += st;
            }
        }
        if (arr[n] == 0) {
            result++;
        }
        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, m, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backTracking(0, 0);
        if (m == 0) {
            result--;
        }
        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }

    private static void backTracking(int idx, int sum) {
        if (idx == n) {
            if (sum == m) {
                result++;
            }
            return;
        }
        backTracking(idx + 1, sum + arr[idx]);
        backTracking(idx + 1, sum);
    }
}
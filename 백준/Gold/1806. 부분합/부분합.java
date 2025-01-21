import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, m;

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

        int sum = arr[0];
        int end = 0;
        int length = n + 1;
        for (int start = 0; start < n; start++) {
            while (end < n && sum < m) {
                end++;
                if (end != n) {
                    sum += arr[end];
                }
            }
            if (end == n) {
                break;
            }
            length = Math.min(length, (end - start) + 1);
            sum -= arr[start];
        }
        if (length == n + 1) {
            length = 0;
        }
        bw.write(length + "");
        br.close();
        bw.close();
    }
}
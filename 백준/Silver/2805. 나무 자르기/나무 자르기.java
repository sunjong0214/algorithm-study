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
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int start = 0;
        int end = max;
        int result = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += (arr[i] - mid);
                }
            }
            if (sum == m) {
                result = mid;
                break;
            }
            if (sum >= m) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
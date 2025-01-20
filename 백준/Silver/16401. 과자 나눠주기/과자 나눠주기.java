import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        int start = 0;
        int end = max;
        int idx = 0;
        while (start < end) {
            idx = (start + end + 1) / 2;
            int stick = 0;
            for (int i = m - 1; i >= 0; i--) {
                stick += (arr[i] / idx);
            }
            if (stick >= n) {
                start = idx;
            } else {
                end = idx - 1;
            }
        }
        bw.write(start + "");
        br.close();
        bw.close();
    }
}
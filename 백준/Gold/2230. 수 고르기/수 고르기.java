import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (idx <= i) {
                idx = i;
            }
            for (int j = idx; j < n; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff == m) {
                    bw.write(m + "");
                    br.close();
                    bw.close();
                    return;
                }
                if (diff > m) {
                    min = Math.min(min, diff);
                    idx = j;
                    break;
                }
            }
        }

        bw.write(min + "");
        br.close();
        bw.close();
    }
}
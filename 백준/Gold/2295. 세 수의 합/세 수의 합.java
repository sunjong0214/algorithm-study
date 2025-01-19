import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int[] arr, sum;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sum = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = i; j >= 0; j--) {
                sum[idx++] = arr[j] + arr[i];
            }
        }
        sum = Arrays.copyOf(sum, idx);
        Arrays.sort(sum);
        Arrays.sort(arr);

        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int i1 = Arrays.binarySearch(sum, arr[i] - arr[j]);
                if (i1 >= 0) {
                    max = Math.max(max, sum[i1] + arr[j]);
                }
            }
        }

        bw.write(max + "");
        br.close();
        bw.close();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        // 양수면 end 이동, 음수면 start 이동
        while (start < end) {
            if (min > Math.abs(arr[start] + arr[end])) {
                result[0] = arr[start];
                result[1] = arr[end];
                min = Math.abs(arr[start] + arr[end]);
            }
            if (arr[start] + arr[end] < 0) {
                start++;
            } else if (arr[start] + arr[end] > 0) {
                end--;
            } else {
                result[0] = arr[start];
                result[1] = arr[end];
                break;
            }
        }

        bw.write(result[0] + " " + result[1]);
        br.close();
        bw.close();
    }
}
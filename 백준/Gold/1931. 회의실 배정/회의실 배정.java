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
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            else {
                return a[1] - b[1];
            }
        });

        int num = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= num) {
                result++;
                num = arr[i][1];
            }
        }
        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }
}
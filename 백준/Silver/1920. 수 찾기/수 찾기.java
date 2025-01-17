import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = n;
            int result = 0;
            while (end - start > 1) {
                if (arr[0] == num || arr[(end + start) / 2] == num) {
                    result = 1;
                    break;
                }
                if (arr[(end + start) / 2] < num) {
                    start = (end + start) / 2;
                } else if (arr[(end + start) / 2] > num) {
                    end = (end + start) / 2;
                }
            }
            bw.write(result + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
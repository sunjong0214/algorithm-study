import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int max;
    static int[] arr;
    static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] count = new int[100001];
        int start = 0;
        int end = 0;
        while (end < n) {
            while (end < n && count[arr[end]] < k) {
                count[arr[end]]++;
                end++;
            }
            max = Math.max(max, end - start);
            count[arr[start++]]--;
        }

        bw.write(max + "");
        br.close();
        bw.close();
    }
}
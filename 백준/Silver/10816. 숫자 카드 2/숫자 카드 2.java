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
            int start = 0;
            int end = n;
            int num = Integer.parseInt(st.nextToken());
            bw.write(upperIdx(start, end, num) - lowerIdx(start, end, num) + " ");
        }
        br.close();
        bw.close();
    }

    private static int lowerIdx(int start, int end, int num) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int upperIdx(int start, int end, int num) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] > num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
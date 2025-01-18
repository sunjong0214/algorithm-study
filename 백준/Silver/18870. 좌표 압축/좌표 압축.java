import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, uni;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        uni = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr1 = arr.clone();

        Arrays.sort(arr);

        int idx = 0;
        uni[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (uni[idx] != arr[i]) {
                uni[++idx] = arr[i];
            }
        }

        int[] copy = Arrays.copyOf(uni, idx + 1);

        for (int i = 0; i < n; i++) {
            int uniIdx = Arrays.binarySearch(copy, arr1[i]);
            bw.write(uniIdx + " ");
        }

        br.close();
        bw.close();
    }
}
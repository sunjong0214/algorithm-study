import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    a[i] = Math.max(a[i], a[j] + 1);
                }
            }
        }

        for (int i = n; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (arr[i] > arr[j]) {
                    b[i] = Math.max(b[i], b[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, a[i] + b[i]);
        }

        bw.write(max + "");
        br.close();
        bw.close();
    }
}

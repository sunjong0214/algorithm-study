import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
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
        int sum = 0;
        calculator(arr, 0, sum);
        bw.write(max + "");
        br.close();
        bw.close();
    }

    private static void calculator(int[][] arr, int cursor, int sum) {
        if (cursor > arr.length - 1) {
            max = Math.max(sum, max);
            return;
        }
        for (int i = cursor; i < arr.length; i++) {
            if (i + arr[i][0] > arr.length) calculator(arr, i + arr[i][0], sum);
            else calculator(arr, i + arr[i][0], sum + arr[i][1]);
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        func(1);
        bw.write(Math.min(arr[n - 1][0], Math.min(arr[n - 1][1], arr[n - 1][2])) + "");
        br.close();
        bw.close();
    }

    private static void func(int index) {
        if (index == n) {
            return;
        }
        arr[index][0] += Math.min(arr[index - 1][1], arr[index - 1][2]);
        arr[index][1] += Math.min(arr[index - 1][0], arr[index - 1][2]);
        arr[index][2] += Math.min(arr[index - 1][0], arr[index - 1][1]);
        func(++index);
    }
}
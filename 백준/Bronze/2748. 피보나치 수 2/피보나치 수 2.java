import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];

        arr[0] = 0L;
        arr[1] = 1L;
        func(2);
        bw.write(arr[N] + "");
        br.close();
        bw.close();
    }

    private static void func(int n) {
        if (N == 0) {
            return;
        }
        if (N == 1) {
            return;
        }
        if (n > N) {
            return;
        }
        arr[n] = arr[n - 1] + arr[n - 2];
        func(n + 1);
    }
}
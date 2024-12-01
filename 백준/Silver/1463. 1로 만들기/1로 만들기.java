import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        func(n, 0);
        bw.write(min + "");
        br.close();
        bw.close();
    }

    private static void func(int n, int op) {
        if (n == 1) {
            min = Math.min(min, op);
            return;
        }
        if (min <= op) {
            return;
        }
        if (n % 3 == 0) {
            func(n / 3, op + 1);
        }
        if (n % 2 == 0) {
            func(n / 2, op + 1);
        }
        func(n - 1, op + 1);
    }
}
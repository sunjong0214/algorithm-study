import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            func(num, i);
        }
        for (int result : result) {
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }

    private static void func(int n, int index) {
        if (n == 0) {
            result[index]++;
            return;
        }
        if (n < 0) {
            return;
        }
        func(n - 3, index);
        func(n - 2, index);
        func(n - 1, index);
    }
}
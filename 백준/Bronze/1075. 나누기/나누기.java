import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[][] notebook;
    static int[] degree = {0, 1, 2, 3};
    static int n;
    static int m;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        int num = Integer.MAX_VALUE;

        n -= (n % 100);
        for (int i = 0; i < 100; i++) {
            if ((n + i) % f == 0) {
                num = Math.min(num, i % 100);
            }
        }
        if (num < 10) bw.write("0" + num + "");
        else bw.write(num + "");
        br.close();
        bw.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열
        int sqrt = (int) Math.pow(2, N);
        func(sqrt, r, c);
        System.out.println(result-1);
        br.close();
    }

    // x = 행, y == 열
    private static void func(int n, int x, int y) {
        if (n == 0) {
            return;
        }
        int xTemp = n / 2;
        int yTemp = n / 2;
        if (xTemp <= x && yTemp <= y) {
            result += n * n - (n * n / 4);
            func(n / 2, x - xTemp, y - yTemp); // 1
        } else if (xTemp <= x) {
            result += (n * n) - 2 * (n * n / 4);
            func(n / 2, x - xTemp, y); // 3
        } else if (yTemp <= y) {
            result += (n * n) - 3 * (n * n / 4);
            func(n / 2, x, y - yTemp); // 2
        } else {
            func(n / 2, x, y); // 4
        }
    }
}

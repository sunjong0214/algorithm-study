
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A;
    static long B;
    static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(func(A, B));
        br.close();
    }

    private static long func(long a, long b) {
        if (b == 1) {
            return a % C;
        }
        long result = func(a, b / 2);

        if (b % 2 == 1) {
            return ((result * result % C) * a) % C;
        }

        return result * result % C;
    }
}

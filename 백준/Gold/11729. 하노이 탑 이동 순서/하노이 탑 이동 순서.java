
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        func(1, 3, N);
        System.out.println(x);
        System.out.print(sb);
        br.close();
    }

    private static void func(int a, int b, int N) {
        if (N == 0) {
            return;
        }
        func(a, 6 - (a + b), N - 1);
        x++;
        sb.append(a).append(" ").append(b).append("\n");
        func(6 - (a + b), b, N - 1);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[] color = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, N);

        System.out.println(color[0]);
        System.out.println(color[1]);
        br.close();
    }

    static void func(int y, int x, int n) {
        if (cheak(y, x, n)) {
            color[arr[y][x]]++;
            return;
        }
        int idx = n / 2;
        func(y, x, idx);
        func(y + idx, x, idx);
        func(y, x + idx, idx);
        func(y + idx, x + idx, idx);
    }

    private static boolean cheak(int y, int x, int n) {
        int s = arr[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (s != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}

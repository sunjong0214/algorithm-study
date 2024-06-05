import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[] result = new int[3];
    static int N;

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

        for (int x : result) {
            System.out.println(x);
        }
        br.close();
    }

    static void func(int y, int x, int n) {
        if (check(y, x, n)) {
            result[arr[y][x] + 1]++;
            return;
        }

        int index = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                func(y + i * index, x + j * index, index);
            }
        }
    }

    private static boolean check(int y, int x, int n) {
        int s = arr[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (arr[i][j] != s) {
                    return false;
                }
            }
        }
        return true;
    }
}

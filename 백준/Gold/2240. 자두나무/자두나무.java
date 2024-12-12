import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int move;
    static int[] dropTree;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        move = Integer.parseInt(st.nextToken());
        dropTree = new int[n + 1];
        result = new int[n + 1][move + 1];
        for (int i = 1; i < n + 1; i++) {
            dropTree[i] = Integer.parseInt(br.readLine());
            for (int j = 0; j < move + 1; j++) {
                if (dropTree[i] == j % 2 + 1) {
                    result[i][j] = result[i - 1][j] + 1;
                } else {
                    result[i][j] = result[i - 1][j];
                }
                if (j > 0) {
                    if (dropTree[i] == j % 2 + 1) {
                        result[i][j] = Math.max(result[i][j], result[i - 1][j - 1] + 1);
                    } else {
                        result[i][j] = Math.max(result[i][j], result[i - 1][j - 1]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < move + 1; i++) {
            max = Math.max(max, result[n][i]);
        }
        bw.write(max + "");
        br.close();
        bw.close();
    }
}
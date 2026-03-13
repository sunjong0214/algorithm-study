import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int cnt;
    static boolean[] col;
    static boolean[] dr;
    static boolean[] dl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        col = new boolean[n];
        dr = new boolean[n + n];
        dl = new boolean[n + n];

        queen(0);

        bw.write(cnt + "");
        br.close();
        bw.close();
    }

    private static void queen(int row) {
        if (row == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || dr[i + row] || dl[n + i - row]) continue;
            col[i] = true;
            dr[i + row] = true;
            dl[n + i - row] = true;
            queen(row + 1);
            col[i] = false;
            dr[i + row] = false;
            dl[n + i - row] = false;
        }
    }
}
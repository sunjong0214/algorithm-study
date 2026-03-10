import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] numA;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numA = new int[m + 1];

        back(1);

        br.close();
        bw.close();
    }

    static void back(int depth) throws IOException {
        if (depth == m + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= m; i++) {
                sb.append(numA[i]).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (i < numA[depth - 1]) continue;
            numA[depth] = i;
            back(depth + 1);
        }

    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] minDp, maxDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        minDp = new int[3];
        maxDp = new int[3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x0 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            if (i == 1) {
                minDp[0] = maxDp[0] = x0;
                minDp[1] = maxDp[1] = x1;
                minDp[2] = maxDp[2] = x2;
                continue;
            }

            int b0 = maxDp[0];
            int b1 = maxDp[1];
            int b2 = maxDp[2];
            maxDp[0] = Math.max(b0, b1) + x0;
            maxDp[1] = Math.max(b0, Math.max(b1, b2)) + x1;
            maxDp[2] = Math.max(b1, b2) + x2;

            b0 = minDp[0];
            b1 = minDp[1];
            b2 = minDp[2];
            minDp[0] = Math.min(b0, b1) + x0;
            minDp[1] = Math.min(b0, Math.min(b1, b2)) + x1;
            minDp[2] = Math.min(b1, b2) + x2;
        }
        bw.write(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " " + Math.min(minDp[0],
                Math.min(minDp[1], minDp[2])));
        br.close();
        bw.close();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 0 = 시작, 1 = 끝, 2 = 거리
        int[][] fast = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            fast[i][0] = Integer.parseInt(st.nextToken());
            fast[i][1] = Integer.parseInt(st.nextToken());
            fast[i][2] = Integer.parseInt(st.nextToken());
        }

        int dis = 1;
        int[] dp = new int[d + 1];
        while (dis <= d) {
            dp[dis] = dp[dis - 1] + 1;
            for (int i = 0; i < n; i++) {
                if (dis == fast[i][1]) {
                    // 기존 dp랑 지름길로 이용한 거리 비교
                    dp[dis] = Math.min(dp[dis], dp[fast[i][0]] + fast[i][2]);
                }
            }
            dis++;
        }
        bw.write(dp[d] + "\n");
        br.close();
        bw.close();
    }
}
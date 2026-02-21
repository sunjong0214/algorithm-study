import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int maxCnt = 0;
    static int[][] arr;
    static List<int[]> q; // CCTV 정보 담을 리스트

    // 0: 상, 1: 우, 2: 하, 3: 좌 (시계 방향)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        q = new ArrayList<>();
        int noCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // CCTV(1~5)인 경우 리스트에 추가
                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                    q.add(new int[]{i, j, arr[i][j]});
                    noCnt++;
                }
                if (arr[i][j] == 6) noCnt++;
            }
        }

        // 경우의 수 셋팅 -> 3진수로 바꾸기 개수만큼 (3의 n승)
        int sq = (int) Math.pow(4, q.size());

        for (int i = 0; i <= sq; i++) {
            // i를 3진수로 변경하면서 해당 나머지가 cctv 방향이 되는 것
            int temp = i;
            int idx = 0;
            int cnt = 0;
            int[][] visit = new int[n][m];
            while (idx < q.size()) {
                int head = temp % 4; // cctv 방향
                temp /= 4;
                int[] cctv = q.get(idx);
                if (cctv[2] == 1) {
                    cnt += watch(cctv[0], cctv[1], dx[head], dy[head], visit);
                } else if (cctv[2] == 2) {
                    cnt += watch(cctv[0], cctv[1], dx[(head + 1) % 4], dy[(head + 1) % 4], visit);
                    cnt += watch(cctv[0], cctv[1], dx[(head + 3) % 4], dy[(head + 3) % 4], visit);
                } else if (cctv[2] == 3) {
                    cnt += watch(cctv[0], cctv[1], dx[(head + 1) % 4], dy[(head + 1) % 4], visit);
                    cnt += watch(cctv[0], cctv[1], dx[(head + 2) % 4], dy[(head + 2) % 4], visit);
                } else if (cctv[2] == 4) {
                    cnt += watch(cctv[0], cctv[1], dx[(head + 1) % 4], dy[(head + 1) % 4], visit);
                    cnt += watch(cctv[0], cctv[1], dx[(head + 2) % 4], dy[(head + 2) % 4], visit);
                    cnt += watch(cctv[0], cctv[1], dx[(head + 3) % 4], dy[(head + 3) % 4], visit);
                } else if (cctv[2] == 5) {
                    cnt += watch(cctv[0], cctv[1], dx[(head + 1) % 4], dy[(head + 1) % 4], visit);
                    cnt += watch(cctv[0], cctv[1], dx[(head + 2) % 4], dy[(head + 2) % 4], visit);
                    cnt += watch(cctv[0], cctv[1], dx[(head + 3) % 4], dy[(head + 3) % 4], visit);
                    cnt += watch(cctv[0], cctv[1], dx[(head + 4) % 4], dy[(head + 4) % 4], visit);
                }
                idx++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        bw.write(((n * m) - noCnt - maxCnt) + "\n");
        br.close();
        bw.close();
    }

    static int watch(int x, int y, int mx, int my, int[][] visit) {
        int cnt = 0;
        int zx = x + mx;
        int zy = y + my;
        while (true) {
            if (zx < 0 || zx >= n || zy < 0 || zy >= m || arr[zx][zy] == 6) return cnt;
            if (visit[zx][zy] == 0 && arr[zx][zy] == 0) cnt++;
            visit[zx][zy] = 1;
            zx += mx;
            zy += my;
        }
    }
}
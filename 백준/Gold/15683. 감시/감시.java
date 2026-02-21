import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int minM = Integer.MAX_VALUE;
    static List<int[]> q; // CCTV 정보 담을 리스트

    // 0: 상, 1: 우, 2: 하, 3: 좌 (시계 방향)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 1~5번 CCTV의 회전 가능한 경우의 수
    static int[] spinCnt = {0, 4, 2, 4, 4, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        q = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // CCTV(1~5)인 경우 리스트에 추가
                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                    q.add(new int[]{i, j, arr[i][j]});
                }
            }
        }

        // 0번째 CCTV부터 탐색 시작, 초기 맵 상태 전달
        back(0, arr);

        bw.write(minM + "\n");
        br.close();
        bw.close();
    }

    // idx: 현재 탐색 중인 CCTV의 인덱스
    // board: 현재까지 감시가 완료된 맵의 상태
    static void back(int idx, int[][] board) {
        // 기저 조건: 모든 CCTV를 다 확인한 경우
        if (idx == q.size()) {
            int blindSpotCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0) blindSpotCount++;
                }
            }
            minM = Math.min(minM, blindSpotCount);
            return;
        }

        int[] cctv = q.get(idx);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];

        // 해당 CCTV 타입이 가질 수 있는 모든 방향 회전
        for (int dir = 0; dir < spinCnt[type]; dir++) {
            // 1. 현재 맵 상태를 복사 (다음 탐색이 이전 탐색에 영향을 주지 않도록)
            int[][] nextBoard = copyBoard(board);

            // 2. CCTV 타입에 맞춰 감시 영역 칠하기 (-1로 표시)
            if (type == 1) {
                watch(x, y, dir, nextBoard);
            } else if (type == 2) {
                watch(x, y, dir, nextBoard);
                watch(x, y, dir + 2, nextBoard); // 반대 방향
            } else if (type == 3) {
                watch(x, y, dir, nextBoard);
                watch(x, y, dir + 1, nextBoard); // 직각 방향
            } else if (type == 4) {
                watch(x, y, dir, nextBoard);
                watch(x, y, dir + 1, nextBoard);
                watch(x, y, dir + 2, nextBoard);
            } else if (type == 5) {
                watch(x, y, 0, nextBoard);
                watch(x, y, 1, nextBoard);
                watch(x, y, 2, nextBoard);
                watch(x, y, 3, nextBoard);
            }

            // 3. 다음 CCTV 탐색 진행 (재귀)
            back(idx + 1, nextBoard);
        }
    }

    // 특정 방향(dir)으로 감시할 수 있는 영역을 -1로 채우는 함수
    static void watch(int x, int y, int dir, int[][] board) {
        dir %= 4; // 방향 인덱스가 4를 넘지 않도록 처리
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
            if (board[nx][ny] == 6) break; // 벽을 만나면 시야 차단
            if (board[nx][ny] == 0) board[nx][ny] = -1; // 빈 칸이면 감시 영역으로 표시
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    // 2차원 배열 깊은 복사 함수
    static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, m);
        }
        return copy;
    }
}
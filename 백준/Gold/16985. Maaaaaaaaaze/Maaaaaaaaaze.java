import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] arr;
    static boolean[][][] visited;
    static int[][][] distance;
    static boolean[] isSelect = new boolean[5];
    static int[] num = new int[5];
    static int min;

    static int[] dx = {0, 0, 1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {1, 0, 0, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        arr = new int[5][5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        // 4의 5승 -> 5개의 판이 4가지 경우가 있으니까
        // 모든 경우의 수 확인하면서 각 입구 dfs
        // 근데 꼭지점 별로 다 확인 필요
        // 4의 5승 * 4개의 꼭지점 * (5 * 5 * 5)
        // dfs 시 만약 0이면 continue, 만약 distance 가 작으면 continue 등?

        min = Integer.MAX_VALUE;

        selected(0);

        if (min == Integer.MAX_VALUE) min = 0;
        bw.write((min - 1) + "");
        br.close();
        bw.close();
    }

    static void spinAndBfs() {
        int p = (int) Math.pow(4, 5);
        for (int i = 0; i < p; i++) {
            int temp = i;
            int[][][] spinArr = new int[5][5][5];
            for (int j = 0; j < 5; j++) {

                int head = temp % 4;
                temp = temp / 4;

                int[][] matrix = arr[num[j]];

                spinArr[j] = spin(matrix, head);
            }

            visited = new boolean[5][5][5];
            distance = new int[5][5][5];
            min = Math.min(dfs(spinArr), min);
            if (min == 13) break;
        }
    }

    static void selected(int depth) {
        if (depth == 5) {
            spinAndBfs();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (!isSelect[i]) {
                num[depth] = i;
                isSelect[i] = true;
                selected(depth + 1);
                isSelect[i] = false;
            }
        }
    }

    static int dfs(int[][][] spinArr) {
        int startX = 0;
        int startY = 0;
        int startZ = 0;
        int targetZ = 4;
        int targetX = 4;
        int targetY = 4;
        if (spinArr[startZ][startX][startY] == 0 || spinArr[targetZ][targetX][targetY] == 0) return Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startZ, startX, startY});
        visited[startZ][startX][startY] = true;
        distance[startZ][startX][startY] = 1;

        while (!q.isEmpty()) {
            int[] pop = q.poll();
            if (pop[0] == targetZ && pop[1] == targetX && pop[2] == targetY) return distance[pop[0]][pop[1]][pop[2]];

            for (int i = 0; i < 6; i++) {
                int mz = pop[0] + dz[i];
                int mx = pop[1] + dx[i];
                int my = pop[2] + dy[i];
                if (mz < 0 || mz >= 5 || mx < 0 || mx >= 5 || my < 0 || my >= 5) continue;
                if (visited[mz][mx][my]) continue;
                if (spinArr[mz][mx][my] == 0) continue;
                if (distance[mz][mx][my] != 0 && distance[mz][mx][my] < distance[pop[0]][pop[1]][pop[2]]) continue;

                q.offer(new int[]{mz, mx, my});
                visited[mz][mx][my] = true;
                distance[mz][mx][my] = distance[pop[0]][pop[1]][pop[2]] + 1;
            }
        }

        return distance[targetZ][targetX][targetY] == 0 ? Integer.MAX_VALUE : distance[targetZ][targetX][targetY];
    }

    static int[][] spin(int[][] matrix, int head) {
        if (head <= 0) return matrix;
        int[][] temp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                temp[i][j] = matrix[4 - j][i];
            }
        }
        return spin(temp, head - 1);
    }
}
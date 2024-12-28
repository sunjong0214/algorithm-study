import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] isVisited;
    static Queue<int[]> fire;
    static Queue<int[]> sang;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            isVisited = new boolean[x][y];
            arr = new int[x][y];
            fire = new LinkedList<>();
            sang = new LinkedList<>();
            init(x, y, br);
            while (!sang.isEmpty()) {
                int fSize = fire.size();
                for (int k = 0; k < fSize; k++) {
                    int fX = fire.peek()[0];
                    int fY = fire.poll()[1];
                    for (int j = 0; j < 4; j++) {
                        int fMX = fX + dx[j];
                        int fMY = fY + dy[j];
                        if (fMX < 0 || fMX >= x || fMY < 0 || fMY >= y) {
                            continue;
                        }
                        if (isVisited[fMX][fMY]) {
                            continue;
                        }
                        fire.offer(new int[]{fMX, fMY});
                        isVisited[fMX][fMY] = true;
                        arr[fMX][fMY] = 1000001;
                    }
                }
                int sSize = sang.size();
                for (int k = 0; k < sSize; k++) {
                    int sX = sang.peek()[0];
                    int sY = sang.poll()[1];
                    for (int j = 0; j < 4; j++) {
                        int sMX = sX + dx[j];
                        int sMY = sY + dy[j];
                        if (sMX < 0 || sMX >= x || sMY < 0 || sMY >= y) {
                            continue;
                        }
                        if (isVisited[sMX][sMY]) {
                            continue;
                        }
                        sang.offer(new int[]{sMX, sMY});
                        isVisited[sMX][sMY] = true;
                        arr[sMX][sMY] = arr[sX][sY] + 1;
                    }
                }
            }
            bw.write(check(x, y));
        }
        br.close();
        bw.close();
    }

    private static String check(int x, int y) {
        int max = 1000001;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if ((i == 0 || i == x - 1) || (j == 0 || j == y - 1)) {
                    max = Math.min(max, arr[i][j]);
                }
            }
        }
        if (max == 1000001) {
            return "IMPOSSIBLE\n";
        } else {
            return max + "\n";
        }
    }

    private static void init(int x, int y, BufferedReader br) throws IOException {
        for (int i = 0; i < x; i++) {
            String input = br.readLine();
            for (int j = 0; j < y; j++) {
                char c = input.charAt(j);
                if (c != '.') {
                    isVisited[i][j] = true;
                }
                arr[i][j] = 1000001;
                if (c == '*') {
                    fire.offer(new int[]{i, j});
                } else if (c == '@') {
                    sang.offer(new int[]{i, j});
                    arr[i][j] = 1;
                }
            }
        }
    }
}
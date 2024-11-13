import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] rgb;
    static boolean[][] isVisited;
    static Queue<int[]> q;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 구역 갯수, 적녹색약 구역 수, isRG, 두번 돌리는걸로 처음 풀어보자
        int count = 0;
        int countRG = 0;
        q = new LinkedList<>();
        n = Integer.parseInt(br.readLine());
        rgb = new char[n][n];
        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                rgb[i][j] = input.charAt(j);
            }
        }
        count = dfs(true);
        isVisited = new boolean[n][n];
        countRG = dfs(false);
        bw.write(count + " " + countRG);
        br.close();
        bw.close();
    }

    private static int dfs(boolean isRGB) {
        int count = 0;
        for (int i = 0; i < rgb.length; i++) {
            for (int j = 0; j < rgb[i].length; j++) {
                if (!isVisited[i][j]) {
                    q.add(new int[]{i, j});
                    isVisited[i][j] = true;
                    char color = rgb[i][j];
                    count++;
                    while (!q.isEmpty()) {
                        int[] poll = q.poll();
                        int x = poll[0];
                        int y = poll[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx < 0 || ny < 0 || nx == n || ny == n) {
                                continue;
                            }
                            if (isVisited[nx][ny]) {
                                continue;
                            }
                            if (!isRGB && (color == 'R' || color == 'G') && (rgb[nx][ny] == 'R'
                                    || rgb[nx][ny] == 'G')) {
                                color = 'R';
                                rgb[nx][ny] = color;
                            }
                            if (rgb[nx][ny] != color) {
                                continue;
                            }
                            q.add(new int[]{nx, ny});
                            isVisited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}
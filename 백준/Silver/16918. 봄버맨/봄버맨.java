import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Boom implements Comparable<Boom> {
        int x;
        int y;
        int second;

        Boom(int x, int y, int second) {
            this.x = x;
            this.y = y;
            this.second = second;
        }

        @Override
        public int compareTo(Boom o) {
            return second - o.second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] matrix1 = new boolean[R][C];
        boolean[][] matrix2 = new boolean[R][C];
        boolean[][] matrix3 = new boolean[R][C];
        boolean[][] matrix4 = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'O') {
                    matrix1[i][j] = true;
                }
            }
        }
        for (boolean[] m : matrix2) {
            Arrays.fill(m, true);
        }
        for (boolean[] m : matrix3) {
            Arrays.fill(m, true);
        }
        for (boolean[] m : matrix4) {
            Arrays.fill(m, true);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix1[i][j]) {
                    matrix3[i][j] = false;
                    for (int z = 0; z < 4; z++) {
                        int x = i + dx[z];
                        int y = j + dy[z];
                        if (x < 0 || x >= R || y < 0 || y >= C) {
                            continue;
                        }
                        matrix3[x][y] = false;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix3[i][j]) {
                    matrix4[i][j] = false;
                    for (int z = 0; z < 4; z++) {
                        int x = i + dx[z];
                        int y = j + dy[z];
                        if (x < 0 || x >= R || y < 0 || y >= C) {
                            continue;
                        }
                        matrix4[x][y] = false;
                    }
                }
            }
        }

        boolean[][] matrix;

        if (N == 1) {
            //기존 상태
            matrix = matrix1;
        } else if (N % 2 == 0) {
            //모두 채워진 상태
            matrix = matrix2;
        } else if (N % 4 == 3) {
            // 기존이 터진 상태
            matrix = matrix3;
        } else {
            // 새로 채워진 것이 터진 상태
            matrix = matrix4;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j]) {
                    bw.write('O');
                } else {
                    bw.write('.');
                }
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
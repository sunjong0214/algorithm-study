import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[21][21];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int I = 0; I < (int) Math.pow(4, 5); I++) {
            int[][] pre = new int[21][21];
            for (int i = 0; i < 21; i++) {
                pre[i] = arr[i].clone();
            }
            int temp = I;
            for (int J = 0; J < 5; J++) {
                int[][] board = new int[21][21];
                int head = temp % 4;
                temp = temp / 4;
                Queue<Integer> q = new LinkedList<>();

                // move -> dx, dy 방향으로 0, 0부터 확인 -> node 발견 해당 방향으로 move
                if (head == 1){
                    for (int i = 20; i >= 0; i--) {
                        for (int j = 20; j >= 0; j--) {
                            if (pre[i][j] != 0) {
                                q.offer(pre[i][j]);
                            }
                        }
                        int idx = 20;
                        while (!q.isEmpty()) {
                            int num = q.poll();

                            if (!q.isEmpty() && q.peek() == num) {
                                board[i][idx--] = num * 2;
                                q.poll();
                            }
                            else board[i][idx--] = num;
                        }
                    }
                } else if (head == 2) {
                    for (int j = 20; j >= 0; j--) {
                        for (int i = 20; i >= 0; i--) {
                            if (pre[i][j] != 0) {
                                q.offer(pre[i][j]);
                            }
                        }
                        int idx = 20;
                        while (!q.isEmpty()) {
                            int num = q.poll();

                            if (!q.isEmpty() && q.peek() == num) {
                                board[idx--][j] = num * 2;
                                q.poll();
                            }
                            else board[idx--][j] = num;
                        }
                    }
                } else if (head == 3) {
                    for (int i = 0; i < 21; i++) {
                        for (int j = 0; j < 21; j++) {
                            if (pre[i][j] != 0) {
                                q.offer(pre[i][j]);
                            }
                        }
                        int idx = 0;
                        while (!q.isEmpty()) {
                            int num = q.poll();

                            if (!q.isEmpty() && q.peek() == num) {
                                board[i][idx++] = num * 2;
                                q.poll();
                            }
                            else board[i][idx++] = num;

                        }
                    }
                } else {
                    for (int j = 0; j < 21; j++) {
                        for (int i = 0; i < 21; i++) {
                            if (pre[i][j] != 0) {
                                q.offer(pre[i][j]);
                            }
                        }
                        int idx = 0;
                        while (!q.isEmpty()) {
                            int num = q.poll();

                            if (!q.isEmpty() && q.peek() == num) {
                                board[idx++][j] = num * 2;
                                q.poll();
                            }
                            else board[idx++][j] = num;

                        }
                    }
                }
                pre = board;
            }
            for (int z = 0; z < 21; z++) {
                for (int k = 0; k < 21; k++) {
                    max = Math.max(pre[z][k], max);
                }
            }
        }

        bw.write(max + "");
        br.close();
        bw.close();
    }

    static void right() {
        int[][] depth = new int[21][21];
        for (int j = 20; j >= 0; j--) {
            for (int i = 20; i >= 0; i--) {
                if (arr[i][j] != 0) {
//                    depth = move(dx[head], dy[head], i, j, depth);
                    for (int mj = j; mj < 20; mj++) {
                        if (arr[i][j + 1] == 0) {
                            arr[i][j + 1] = arr[i][mj];
                            arr[i][mj] = 0;
                        } else {
                            if (arr[i][j + 1] == arr[i][mj] && depth[i][j + 1] == 0) {
                                arr[i][j + 1] += arr[i][mj];
                                arr[i][mj] = 0;
                                depth[i][j + 1] = 1;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    static void left() {
        int[][] depth = new int[21][21];
        for (int j = 0; j < 21; j++) {
            for (int i = 0; i < 21; i++) {
                if (arr[i][j] != 0) {
//                    depth = move(dx[head], dy[head], i, j, depth);
                    for (int mj = j; mj > 0; mj--) {
                        if (arr[i][j - 1] == 0) {
                            arr[i][j - 1] = arr[i][mj];
                            arr[i][mj] = 0;
                        } else {
                            if (arr[i][j - 1] == arr[i][mj] && depth[i][j - 1] == 0) {
                                arr[i][j - 1] += arr[i][mj];
                                arr[i][mj] = 0;
                                depth[i][j - 1] = 1;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    static void bottom() {
        int[][] depth = new int[21][21];
        for (int i = 20; i >= 0; i--) {
            for (int j = 20; j >= 0; j--) {
                if (arr[i][j] != 0) {
//                    depth = move(dx[head], dy[head], i, j, depth);
                    for (int mi = i; mi < 20; mi++) {
                        if (arr[i + 1][j] == 0) {
                            arr[i + 1][j] = arr[mi][j];
                            arr[mi][j] = 0;
                        } else {
                            if (arr[i + 1][j] == arr[mi][j] && depth[i + 1][j] == 0) {
                                arr[i + 1][j] += arr[mi][j];
                                arr[mi][j] = 0;
                                depth[i + 1][j] = 1;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    static int[][] move(int dx, int dy, int i, int j, int[][] depth) {
        while (true) {
            int mx = i + dx;
            int my = j + dy;
            if (0 > mx || mx > 20 || 0 > my || my > 20) return depth;
            if (arr[mx][my] != 0) {
                if (arr[mx][my] == arr[i][j] && depth[mx][my] == 0) {
                    arr[mx][my] += arr[i][j];
                    arr[i][j] = 0;
                    depth[mx][my] = 1;
                    continue;
                }
                depth[i][j] = 1;
                return depth;
            }
            arr[mx][my] = arr[i][j];
            arr[i][j] = 0;
            i = mx;
            j = my;
        }
    }
}
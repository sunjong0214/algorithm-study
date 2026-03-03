import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 굴릴 때 해당 좌표가 0이면 -> 주사위 값을 바닥에 붙이기
        // 아니면 -> 주사위 바닥면으로 복사, 칸은 0
        // 동 = 1, 서 = 2, 북 = 3, 남 = 4
        int[] top = {0, 6, 5, 4, 3, 2, 1};

        int north = 0;
        int front = 0;
        int east = 0;
        int west = 0;
        int back = 0;
        int south = 0;

        int mx = x;
        int my = y;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());
            if (d == 4) {
                mx++;
                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    mx--;
                    continue;
                }
                int temp = north;
                north = back;
                back = south;
                south = front;
                front = temp;
            } else if (d == 3) {
                mx--;
                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    mx++;
                    continue;
                }
                int temp = north;
                north = front;
                front = south;
                south = back;
                back = temp;
            } else if (d == 2) {
                my--;
                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    my++;
                    continue;
                }
                int temp = west;
                west = north;
                north = east;
                east = south;
                south = temp;
            } else {
                my++;
                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    my--;
                    continue;
                }
                int temp = east;
                east = north;
                north = west;
                west = south;
                south = temp;
            }



            if (arr[mx][my] == 0) {
                arr[mx][my] = south;
            } else {
                south = arr[mx][my];
                arr[mx][my] = 0;
            }
            bw.write(north + "\n");
        }

        br.close();
        bw.close();
    }
}
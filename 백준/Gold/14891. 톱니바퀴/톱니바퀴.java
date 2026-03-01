import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 한번 회전할 때 마다 톱니바퀴 모두 확인
        // 회전 시 반시계, 시계 방향 회전 구현 -> 회전 후 -1, 1 에서 인접한 톱니 확인
        // 확인 후 다르면 시계면 -> 반시계, 반시계면 시계로 회전
        // 만약 회전하지 않으면 break -> 다음 회전 사이클
        // 인접 idx -> -1 = 6, 1 = 2

        arr = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String seq = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = seq.charAt(j);
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int spinD = Integer.parseInt(st.nextToken());
            int[] spinArr = new int[4];
            spinArr[idx] = spinD;

            for (int j = idx; j >= 1; j--) {
                if (arr[j][6] != arr[j - 1][2]) spinArr[j - 1] = -spinArr[j];
                else break;
            }

            for (int j = idx; j < 3; j++) {
                if (arr[j][2] != arr[j + 1][6]) spinArr[j + 1] = -spinArr[j];
                else break;
            }

            for (int j = 0; j < 4; j++) {
                if (spinArr[j] != 0) spin(j, spinArr[j]);
            }
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            int plus = 0;
            if (i == 0) plus = 1;
            else if (i == 1) plus = 2;
            else if (i == 2) plus = 4;
            else plus = 8;

            if (arr[i][0] == '1') score += plus;
        }

        bw.write(score + "");
        br.close();
        bw.close();
    }
    static void spin(int idx, int spinD) {
         if (spinD == -1) {
            moveLeft(idx, spinD);
         } else if (spinD == 1) {
            moveRight(idx, spinD);
         }
    }

    static void moveLeft(int idx, int spinD) {
        int temp = arr[idx][0];
        for (int i = 1; i < 8; i++) {
            arr[idx][i - 1] = arr[idx][i];
        }
        arr[idx][7] = temp;
    }

    static void moveRight(int idx, int spinD) {
        int temp = arr[idx][7];
        for (int i = 6; i >= 0; i--) {
            arr[idx][i + 1] = arr[idx][i];
        }
        arr[idx][0] = temp;
    }
}
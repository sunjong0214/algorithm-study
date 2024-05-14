
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] arr = new int[501][501];
  static boolean[][] isVisit = new boolean[501][501];
  static int x;
  static int y;
  static Queue<Integer[]> queue = new LinkedList<>();
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    y = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    setArr(br);
    int[] result = new int[2];
    for (int i = 0; i < y; i++) {
      for (int j = 0; j < x; j++) {
        if (arr[i][j] == 1 && !isVisit[i][j]) {
          queue.add(new Integer[]{i, j});
          isVisit[i][j] = true;

          result[0]++;
          int size = 0;
          while (!queue.isEmpty()) {
            int qy = queue.peek()[0];
            int qx = queue.peek()[1];
            queue.poll();
            size++;
            for (int l = 0; l < 4; l++) {
              if (qy + dy[l] < 0 || qy + dy[l] >= y) {
                continue;
              }
              if (qx + dx[l] < 0 || qx + dx[l] >= x) {
                continue;
              }
              if (arr[qy + dy[l]][qx + dx[l]] == 1 && !isVisit[qy + dy[l]][qx + dx[l]]) {
                queue.add(new Integer[]{qy + dy[l], qx + dx[l]});
                isVisit[qy + dy[l]][qx + dx[l]] = true;
              }
            }
          }
          if (size > result[1]) {
            result[1] = size;
          }
        }
      }
    }
    for (int i : result) {
      System.out.println(i);
    }
    br.close();
  }

  private static void setArr(BufferedReader br) throws IOException {
    StringTokenizer st;
    for (int i = 0; i < y; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < x; j++) {
        int num = Integer.parseInt(st.nextToken());
        arr[i][j] = num;
        if (num == 0) {
          isVisit[i][j] = true;
        }
      }
    }
  }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] cArr = new int[1001][1001];
  static int[][] arr = new int[1001][1001];
  static boolean[][] isVisit = new boolean[1001][1001];
  static int x;
  static int y;
  static Queue<Integer[]> queue = new LinkedList<>();
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int max;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    setArr(br);
    bfs();
    loop:
    for (int i = 0; i < y; i++) {
      for (int j = 0; j < x; j++) {
        if (cArr[i][j] == 0) {
          max = -1;
          break loop;
        }
      }
    }
    System.out.println(max);
    br.close();
  }

  private static void bfs() {
    while (!queue.isEmpty()) {
       int qy = queue.peek()[0];
       int qx = queue.peek()[1];
       queue.poll();
       checking(qy, qx);
    }
  }

  private static void checking(int qy, int qx) {
    for (int i = 0; i < 4; i++) {
      if (qy + dy[i] < 0 || qy + dy[i] >= y) {
        continue;
      }
      if (qx + dx[i] < 0 || qx + dx[i] >= x) {
        continue;
      }
      if (arr[qy + dy[i]][qx + dx[i]] == 0 && !isVisit[qy + dy[i]][qx + dx[i]]) {
        queue.add(new Integer[]{qy + dy[i], qx + dx[i]});
        isVisit[qy + dy[i]][qx + dx[i]] = true;
        cArr[qy + dy[i]][qx + dx[i]] = cArr[qy][qx] + 1;
        if (cArr[qy + dy[i]][qx + dx[i]] > max) {
          max = cArr[qy + dy[i]][qx + dx[i]] - 1;
        }
      }
    }
  }

  private static void setArr(BufferedReader br) throws IOException {
    for (int i = 0; i < y; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < x; j++) {
        int num = Integer.parseInt(st.nextToken());
        arr[i][j] = num;
        if (num == -1) {
          cArr[i][j] = -1;
          isVisit[i][j] = true;
        } else if (num == 1) {
          queue.add(new Integer[]{i, j});
          isVisit[i][j] = true;
          cArr[i][j] = 1;
        }
      }
    }
  }
}

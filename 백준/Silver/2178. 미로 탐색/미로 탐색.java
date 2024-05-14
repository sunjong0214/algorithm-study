
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] cArr = new int[501][501];
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
    queue.add(new Integer[]{0, 0});
    isVisit[0][0] = true;
    cArr[0][0] = 1;
    bfs();
    System.out.println(cArr[y-1][x-1]);
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
      if (arr[qy + dy[i]][qx + dx[i]] == 1 && !isVisit[qy + dy[i]][qx + dx[i]]) {
        queue.add(new Integer[]{qy + dy[i], qx + dx[i]});
        isVisit[qy + dy[i]][qx + dx[i]] = true;
        cArr[qy + dy[i]][qx + dx[i]] = cArr[qy][qx] + 1;
      }
    }
  }

  private static void setArr(BufferedReader br) throws IOException {
    for (int i = 0; i < y; i++) {
      String str = br.readLine();
      for (int j = 0; j < x; j++) {
        int num = str.charAt(j) - 48;
        arr[i][j] = num;
        if (num == 0) {
          isVisit[i][j] = true;
        }
      }
    }
  }
}

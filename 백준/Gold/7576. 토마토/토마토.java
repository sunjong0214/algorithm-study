import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] box = new int[1001][1001]; // 박스
    boolean[][] vis = new boolean[1001][1001]; // 확인한 곳인지
    // int[][] date = new int[1001][1001]; // 몇일째인지

    StringTokenizer st = new StringTokenizer(br.readLine());
    int y = Integer.parseInt(st.nextToken()); // 열
    int x = Integer.parseInt(st.nextToken()); // 행
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < x; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < y; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
        if (box[i][j] == 1) {
          queue.offer(new int[] { i, j });
          vis[i][j] = true;
          // date[i][j] = 0;
        }
      }
    }
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    int rDate = 0;
    while (!queue.isEmpty()) {
      int qx = queue.peek()[0];
      int qy = queue.peek()[1];
      rDate = box[qx][qy];
      queue.poll();
      for (int i = 0; i < 4; i++) {
        int rx = qx + dx[i];
        int ry = qy + dy[i];
        if (rx < 0 || ry < 0 || rx >= x || ry >= y)
          continue;
        if (vis[rx][ry] == true)
          continue;
        vis[rx][ry] = true;
        if (box[rx][ry] != 0)
          continue;
        queue.offer(new int[] { rx, ry });
        box[rx][ry] = rDate + 1;
      }
    }
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (box[i][j] == 0) {
          rDate = 0;
          break;
        }
      }
    }
    System.out.println(rDate-1);
    br.close();
  }
}

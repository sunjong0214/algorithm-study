import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // tc
    StringTokenizer st;

    for (int j = 0; j < n; j++) {

      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()); // 열
      int y = Integer.parseInt(st.nextToken()); // 행
      int cnt = Integer.parseInt(st.nextToken()); // 배추 갯수
      boolean[][] isVisit = new boolean[y][x];
      Queue<int[]> queue = new LinkedList<>();
      int[] dx = { 0, 1, 0, -1 };
      int[] dy = { 1, 0, -1, 0 };
      int result = 0;

      for (int i = 0; i < cnt; i++) {
        st = new StringTokenizer(br.readLine());
        int xTemp = Integer.parseInt(st.nextToken());
        int yTemp = Integer.parseInt(st.nextToken());
        isVisit[yTemp][xTemp] = true;
      }
      int xIndex = 0;
      int yIndex = 0;
      while (true) {
        if (isVisit[yIndex][xIndex] == false) {
          xIndex++;
          if (xIndex == x) {
            xIndex = 0;
            yIndex++;
            if (yIndex == y) {
              break;
            }
          }
          continue;
        }
        isVisit[yIndex][xIndex] = false;
        queue.offer(new int[] { yIndex, xIndex });
        result++;
        while (!queue.isEmpty()) {
          int qy = queue.peek()[0];
          int qx = queue.peek()[1];
          queue.poll();
          for (int k = 0; k < 4; k++) {
            int ty = qy + dy[k];
            int tx = qx + dx[k];
            if (ty < 0 || tx < 0 || ty >= y || tx >= x) {
              continue;
            }
            if (isVisit[ty][tx] == false) {
              continue;
            }
            isVisit[ty][tx] = false;
            queue.offer(new int[] { ty, tx });
          }
        }
      }
      System.out.println(result);
    }
    br.close();
  }
}
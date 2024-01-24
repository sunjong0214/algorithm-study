import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken()); // 행
    int y = Integer.parseInt(st.nextToken()); // 열
    int[][] arr = new int[501][501];
    boolean[][] visited = new boolean[501][501];

    for (int i = 0; i < x; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < y; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[] deX = { 1, 0, -1, 0 };
    int[] deY = { 0, 1, 0, -1 };
    int count = 0;
    int maxArea = 0;
    Queue<int[]> queue = new LinkedList<>();
    int idxX = 0;
    int idxY = 0;
    while (idxX < x || idxY < y) {
      if (arr[idxX][idxY] == 0 || visited[idxX][idxY] == true) {
        idxY++;
        if (idxY > y) {
          idxX++;
          idxY = 0;
        }
        if (idxX > x) {
          break;
        }
        continue;
      }
      queue.offer(new int[] { idxX, idxY });
      visited[idxX][idxY] = true;
      int area = 0;
      area++;
      idxY++;
      if (idxY > y) {
        idxX++;
        idxY = 0;
      }
      if (idxX > x) {
        break;
      }
      while (!queue.isEmpty()) {
        int qX = queue.peek()[0];
        int qY = queue.peek()[1];
        queue.poll();
        for (int i = 0; i < 4; i++) {
          int cX = qX + deX[i];
          int cY = qY + deY[i];
          if (cX < 0 || cX > 501 || cY < 0 || cY > 501)
            continue;
          if (visited[cX][cY] == true)
            continue;
          visited[cX][cY] = true;
          if (arr[cX][cY] == 0)
            continue;
          queue.offer(new int[] { cX, cY });
          area++;
        }
      }
      if (maxArea < area) {
        maxArea = area;
      }
      count++;
    }
    System.out.println(count + "\n" + maxArea);
    br.close();
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int MAX = 1001;
    char[][] arr = new char[MAX][MAX];
    int[][] dist = new int[MAX][MAX];
    boolean[][] isVisit = new boolean[MAX][MAX];
    boolean escape = false;

    StringTokenizer st = new StringTokenizer(br.readLine());
    int y = Integer.parseInt(st.nextToken()); // 행
    int x = Integer.parseInt(st.nextToken()); // 열

    List<Integer> list = new ArrayList<>();
    Queue<int[]> queueJ = new LinkedList<>(); // 지훈이
    Queue<int[]> queueF = new LinkedList<>(); // 불
    for (int i = 0; i < y; i++) {
      String str = br.readLine();
      for (int j = 0; j < x; j++) {
        arr[i][j] = str.charAt(j);
        if (arr[i][j] == ('#')) {
          isVisit[i][j] = true;
        } else if (arr[i][j] == ('J')) {
          queueJ.offer(new int[] { i, j });
          isVisit[i][j] = true;
          dist[i][j] = 1;
        } else if (arr[i][j] == ('F')) {
          queueF.offer(new int[] { i, j });
          isVisit[i][j] = true;
        }
      }
    }
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    int result = 0;
    while (!queueJ.isEmpty()) {
      int qSize = queueF.size();
      if (!queueF.isEmpty()) {
      for (int z = 0; z < qSize; z++) { // 불의 갯수만큼 이동
          int qfy = queueF.peek()[0];
          int qfx = queueF.peek()[1];
          queueF.poll();
          for (int i = 0; i < 4; i++) {
            int cy = qfy + dy[i];
            int cx = qfx + dx[i];
            if (cy >= y || cy < 0 || cx >= x || cx < 0) {
              continue;
            }
            if (isVisit[cy][cx] == true) {
              continue;
            }
            isVisit[cy][cx] = true;
            queueF.offer(new int[] { cy, cx });
          }
        }
      }
      int jSize = queueJ.size();
      for (int a = 0; a < jSize; a++) { // 지훈 이동
        int qjy = queueJ.peek()[0];
        int qjx = queueJ.peek()[1];
        queueJ.poll();
        for (int i = 0; i < 4; i++) {
          int cy = qjy + dy[i];
          int cx = qjx + dx[i];
          if (cy >= y || cy < 0 || cx >= x || cx < 0) {
            escape = true;
            if (list.size() == 0) { // 탈출 가능한 경우 중 가장 작은 값 식별하기
              list.add(dist[qjy][qjx]);
            } else if (list.get(list.size() - 1) > dist[qjy][qjx]) {
              list.remove(0);
              list.add(dist[qjy][qjx]);
            }
            break;
          }
          if (isVisit[cy][cx] == true) {
            continue;
          }
          isVisit[cy][cx] = true;
          queueJ.offer(new int[] { cy, cx });
          dist[cy][cx] = dist[qjy][qjx] + 1;
        }
      }
    }
    int index = 0;
    if (escape) {
      result = list.remove(index);
      System.out.println(result);
    } else {
      System.out.println("IMPOSSIBLE");
    }
    br.close();
  }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;

// public class Main {

//   public static void main(String[] args) throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     StringTokenizer st = new StringTokenizer(br.readLine());
//     int x = Integer.parseInt(st.nextToken()); // 행
//     int y = Integer.parseInt(st.nextToken()); // 열
//     int[][] board = new int[101][101];
//     boolean[][] vis = new boolean[101][101];
//     int[][] dit = new int[101][101];
//     // 초기 보드 설정
//     for (int i = 0; i < x; i++) {
//       String str = br.readLine();
//       for (int j = 0; j < y; j++) {
//         board[i][j] = str.charAt(j) - 48;
//       }
//     }
//     // 상하좌우 비교할 값
//     int[] dx = { 1, 0, -1, 0 };
//     int[] dy = { 0, 1, 0, -1 };

//     Queue<int[]> queue = new LinkedList<>();
//     queue.offer(new int[] { 0, 0 });
//     vis[0][0] = true;
//     int result = 0;
//     dit[0][0] = 0;
//     while (!queue.isEmpty()) {
//       int qx = queue.peek()[0];
//       int qy = queue.peek()[1];
//       result = dit[qx][qy] + 1;
//       queue.poll();
//       for (int i = 0; i < 4; i++) {
//         int rx = qx + dx[i];
//         int ry = qy + dy[i];
//         if (rx < 0 || rx > 100 || ry < 0 || ry > 100)
//           continue;
//         if (vis[rx][ry] == true)
//           continue;
//         vis[rx][ry] = true;
//         if (board[rx][ry] == 0) 
//           continue;
//         queue.offer(new int[] { rx, ry });
//         dit[rx][ry] = result;
//       }
//     }
//     System.out.println(dit[x-1][y-1] + 1);
//     br.close();
//   }
// }

// 내가 리팩토링 해본 코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Board {
  int[][] board;
  boolean[][] vis;
  int[][] dit;

  public Board() {
    this.board = new int[101][101];
    this.vis = new boolean[101][101];
    this.dit = new int[101][101];
  }

  public void addboard(int x, int y, char c) {
    this.board[x][y] = c - 48;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken()); // 행
    int y = Integer.parseInt(st.nextToken()); // 열
    Board board = new Board();
    // 초기 보드 설정
    for (int i = 0; i < x; i++) {
      String str = br.readLine();
      for (int j = 0; j < y; j++) {
        board.addboard(i,j, str.charAt(j));
      }
    }
    // 상하좌우 비교할 값
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { 0, 0 });
    board.vis[0][0] = true;
    board.dit[0][0] = 0;
    execute(board, queue, dx, dy);
    System.out.println(board.dit[x - 1][y - 1] + 1);
    br.close();
  }
  
  static void execute(Board board, Queue<int[]> queue, int[] dx, int[] dy) {
    int result = 0;
    while (!queue.isEmpty()) {
      int qx = queue.peek()[0];
      int qy = queue.peek()[1];
      result = board.dit[qx][qy] + 1;
      queue.poll();
      for (int i = 0; i < 4; i++) {
        int rx = qx + dx[i];
        int ry = qy + dy[i];
        if (rx < 0 || rx > 100 || ry < 0 || ry > 100)
          continue;
        if (board.vis[rx][ry] == true)
          continue;
          board.vis[rx][ry] = true;
        if (board.board[rx][ry] == 0)
          continue;
        queue.offer(new int[] { rx, ry });
        board.dit[rx][ry] = result;
      }
    }
  }
}


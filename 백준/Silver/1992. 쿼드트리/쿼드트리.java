import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[][] arr;
  static int zero;
  static int one;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    sb = new StringBuilder();
    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        arr[i][j] = s.charAt(j) - 48;
      }
    }
    Tree(N, 0, 0);
    System.out.println(sb);
    br.close();
  }

  static boolean check(int n, int x, int y) {
    for (int i = x; i < n + x; i++) {
      for (int j = y; j < n + y; j++) {
        if (arr[x][y] != arr[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  static void Tree(int n, int x, int y) {
    if (check(n, x, y) == true) {
      sb.append(arr[x][y]);
      return;
    }
    n /= 2;
    sb.append("(");
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        Tree(n, x + i * n, y + j * n);
      }
    }
    sb.append(")");
  }
}
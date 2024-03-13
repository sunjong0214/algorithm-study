import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] arr;
  static int[] num = new int[3];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    func(n, 0, 0);

    for (int z : num) {
      System.out.println(z);
    }

    br.close();
  }

  static boolean paper(int idx, int x, int y) {
    for (int i = x; i < x + idx; i++) {
      for (int j = y; j < y + idx; j++) {
        if (arr[x][y] != arr[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  static void func(int idx, int x, int y) {
    if (paper(idx, x, y)) {
      num[arr[x][y] + 1]++;
      return;
    }
    idx /= 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        func(idx, x + i * idx, y + j * idx);
      }
    }
  }
}
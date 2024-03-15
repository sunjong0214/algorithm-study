import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[][] paper;
  static int blue;
  static int white;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    paper = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    cutting(n, 0, 0);
    bw.write(white + "\n");
    bw.write(blue + "\n");
    br.close();
    bw.close();
  }

  static boolean check(int n, int x, int y) {
    for (int i = x; i < x + n; i++) {
      for (int j = y; j < y + n; j++) {
        if (paper[x][y] != paper[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  static void cutting(int n, int x, int y) {
    if (check(n, x, y)) {
      if (paper[x][y] == 1) {
        blue++;
      } else {
        white++;
      }
      return;
    }
    n /= 2;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        cutting(n, x + i * n, y + j * n);
      }
    }
  }
}
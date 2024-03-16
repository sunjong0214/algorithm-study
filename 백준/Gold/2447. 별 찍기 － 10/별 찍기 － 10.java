import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static char[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    arr = new char[N][N];
    Star(N, 0, 0);
    for (char[] ca : arr) {
      for (char c : ca) {
        bw.write(c + "");
      }
      bw.write("\n");
    }
    br.close();
    bw.close();
  }

  static void Stamp(int n, int x, int y) {
    for (int i = x; i < n + x; i++) {
      for (int j = y; j < n + y; j++) {
        arr[i][j] = '*';
      }
    }
  }

  static void StampSpace(int n, int x, int y) {
    for (int i = x; i < n + x; i++) {
      for (int j = y; j < n + y; j++) {
        arr[i][j] = ' ';
      }
    }
  }

  static void Star(int n, int x, int y) {
    if (n < 3) {
      return;
    }
    Stamp(n, x, y);
    n /= 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
          StampSpace(n, x + i * n, y + j * n);
          continue;
        }
        Star(n, x + i * n, y + j * n);
      }
    }
  }
}
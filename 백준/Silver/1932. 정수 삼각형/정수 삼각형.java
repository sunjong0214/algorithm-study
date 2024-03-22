import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[][] D = new int[1005][1005];
  static int[][] arr = new int[1005][1005];
  static int N;
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int z = st.countTokens();
      for (int j = 0; j < z; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (i == N - 1) {
          D[i + 1][j] = arr[i][j];
        }
      }
    }
    func(N - 1, 0);
    bw.write(D[1][0] + "\n");
    br.close();
    bw.close();
  }

  static void func(int x, int y) {
    if (x == 0) {
      return;
    }
    if (y + 1 > x) {
      func(x - 1, 0);
    } else {
      D[x][y] = (D[x + 1][y] > D[x + 1][y + 1] ? D[x + 1][y] : D[x + 1][y + 1]) + arr[x - 1][y];
      func(x, y + 1);
    }
    return;
  }
}
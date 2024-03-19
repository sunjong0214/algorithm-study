import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[] stairs = new int[305];
  static int[][] D = new int[305][2]; // 0 = 전꺼 밟음, 1 = 안 밟음
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }
    D[1][0] = stairs[0];
    D[2][0] = stairs[1];
    D[2][1] = stairs[1] + stairs[0];
    func(3);
    bw.write(Math.max(D[N][0], D[N][1]) + "\n");
    br.close();
    bw.close();
  }

  static void func(int x) {
    if (N == 0 || N == 1 || N == 2) {
      return;
    }
    D[x][0] = Math.max(D[x - 2][0] + stairs[x - 1], D[x - 2][1] + stairs[x - 1]);
    D[x][1] = D[x - 1][0] + stairs[x - 1];
    if (x != N) {
      func(x + 1);
    } else {
      return;
    }
  }
}
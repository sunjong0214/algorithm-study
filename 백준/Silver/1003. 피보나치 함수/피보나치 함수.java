import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[][] D = new int[100][2];
  static int N;
  static int num;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    D[0][0] = 1;
    D[0][1] = 0;
    D[1][0] = 0;
    D[1][1] = 1;
    for (int i = 0; i < N; i++) {
      num = Integer.parseInt(br.readLine());
      func(2);
      bw.write(D[num][0] + " " + D[num][1] + "\n");
    }
    br.close();
    bw.close();
  }

  static void func(int x) {
    if (num == 0 || num == 1) {
      return;
    }
    D[x][0] = D[x - 1][0] + D[x - 2][0];
    D[x][1] = D[x - 1][1] + D[x - 2][1];
    if (x == num) {
      return;
    }
    func(x + 1);
  }
}
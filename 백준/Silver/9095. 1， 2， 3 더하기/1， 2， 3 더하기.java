import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static int[] D = new int[11];
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    D[1] = 1;
    D[2] = 2;
    D[3] = 4;
    for (int i = 0; i < N; i++) {
      n = Integer.parseInt(br.readLine());
      func(4);
      bw.write(D[n] + "\n");
    }
    br.close();
    bw.close();
  }

  static void func(int x) {
    if (n == 0 || n == 1 || n == 2 || n == 3) {
      return;
    }
    if (x == n) {
      D[x] = D[x - 1] + D[x - 2] + D[x - 3];
      return;
    }
    D[x] = D[x - 1] + D[x - 2] + D[x - 3];
    func(x + 1);
  }
}
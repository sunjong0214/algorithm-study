import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[] D = new int[2000];
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());

    D[1] = 1;
    D[2] = 2;
    func(3);
    bw.write(D[N] + "\n");
    br.close();
    bw.close();
  }

  static void func(int x) {
    if (N == 1 || N == 2) {
      return;
    }
    D[x] = (D[x - 1] + D[x - 2]) % 10007;
    if (x != N) {
      func(x + 1);
    }
    return;
  }
}
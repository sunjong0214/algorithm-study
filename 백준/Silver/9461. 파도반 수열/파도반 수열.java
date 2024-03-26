import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static long[] D = new long[105];
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    D[0] = 0L;
    D[1] = 1L;
    D[2] = 1L;
    D[3] = 1L;
    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(br.readLine());
      for (int j = 4; j <= n; j++) {
        D[j] = D[j - 2] + D[j - 3];
      }
      bw.write(D[n] + "\n");
    }
    br.close();
    bw.close();
  }
}
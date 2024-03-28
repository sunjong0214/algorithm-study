import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int lcm = LCM(n, m); // 최대값

      x--;
      y--;
      int result = x;
      while (result <= lcm) {
        if (result % m == y) {
          result++;
          break;
        }
        result += n;
      }
      if (result > lcm) {
        result = -1;
      }
      bw.write(result + "\n");
    }
    br.close();
    bw.close();
  }

  static int GCD(int a, int b) {
    if (b == 0) {
      return a;
    }
    return GCD(b, a % b);
  }

  static int LCM(int a, int b) {
    return a * b / GCD(a, b);
  }
}
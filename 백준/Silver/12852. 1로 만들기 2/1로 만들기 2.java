import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[] D = new int[1000005];
  static int[] div = new int[1000005];
  static int N;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    sb = new StringBuilder();

    D[1] = 0;
    div[1] = 0;
    D[2] = 1;
    div[2] = 1;
    D[3] = 1;
    div[3] = 1;
    func(4);
    bw.write(D[N] + "\n");
    bw.write(N + " ");
    while (N > 1) {
      bw.write(div[N] + " ");
      N = div[N];
    }
    br.close();
    bw.close();
  }

  static void func(int x) {
    if (N == 1 || N == 2 || N == 3) {
      return;
    }
    while (x <= N) {
      int num = 0;
      int three = 0;
      int two = 0;
      int one = 0;
      if (x % 3 == 0) {
        three = D[x / 3] + 1;
      }
      if (x % 2 == 0) {
        two = D[x / 2] + 1;
      }
      one = D[x - 1] + 1;
      if (three == 0 && two != 0) {
        num = Math.min(one, two);
        if (num == one) {
          div[x] = x - 1;
        } else {
          div[x] = x / 2;
        }
      } else if (two == 0 && three != 0) {
        num = Math.min(three, one);
        if (num == one) {
          div[x] = x - 1;
        } else {
          div[x] = x / 3;
        }
      } else if (two == 0 && three == 0) {
        num = one;
        div[x] = x - 1;
      } else {
        num = Math.min(three, Math.min(two, one));
        if (num == one) {
          div[x] = x - 1;
        } else if (num == two) {
          div[x] = x / 2;
        } else {
          div[x] = x / 3;
        }
      }
      D[x] = num;
      x++;
    }
  }
}
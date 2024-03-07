import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[] D;
  static int n;
  static int one;
  static int two;
  static int three;
  static int num;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    D = new int[1000001];
    D[1] = 0;
    if (n != 1) {
      func(2);
    } else {
      System.out.println(0);
    }
    br.close();
  }

  static void func(int x) {
    if (x == 1) {
      System.out.println(1);
      return;
    }
    if (x == n) {
      num = D[x - 1] + 1;
      if (x % 3 == 0) {
        if (num > D[x / 3] + 1) {
          num = D[x / 3] + 1;
        }
      }
      if (x % 2 == 0) {
        if (num > D[x / 2] + 1) {
          num = D[x / 2] + 1;
        }
      }
      System.out.println(num);
      return;
    }
    num = D[x - 1] + 1;
    if (x % 3 == 0) {
      if (num > D[x / 3] + 1) {
        num = D[x / 3] + 1;
      }
    }
    if (x % 2 == 0) {
      if (num > D[x / 2] + 1) {
        num = D[x / 2] + 1;
      }
    }
    D[x] = num;
    func(x + 1);
  }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int n, result = 0;
  static int[] arr = new int[40];
  static boolean[] isUsed = new boolean[40]; // 행
  static boolean[] isLUsed = new boolean[40]; // 왼쪽 : x - y가 같음
  static boolean[] isRUsed = new boolean[40]; // 오른쪽 : x + y가 같음
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    n = Integer.parseInt(br.readLine());
    func(0);
    System.out.println(result);
    br.close();
  }

  static void func(int k) throws IOException {
    if (k == n) {
      result++;
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!isUsed[i] && !isLUsed[k-i+n] && !isRUsed[k+i]) {
        isUsed[i] = true;
        isLUsed[k-i+n] = true;
        isRUsed[k+i] = true;
        func(k+1);
        isUsed[i] = false;
        isLUsed[k-i+n] = false;
        isRUsed[k+i] = false;
      }
    }
  }
}

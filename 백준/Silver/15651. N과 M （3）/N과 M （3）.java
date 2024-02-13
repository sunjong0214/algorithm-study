import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static int[] arr = new int[10];
  static boolean[] isUsed = new boolean[10];
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    func(0);
    br.close();
    bw.close();
  }

  static void func(int k) throws IOException {
    if (k == m) {
      for (int i = 0; i < m; i++) {
        bw.write(arr[i] + " ");
      }
      bw.write("\n");
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!isUsed[i]) {
        arr[k] = i;
        // isUsed[i] = true;
        func(k + 1);
        // isUsed[i] = false;
      }
    }
  }
}

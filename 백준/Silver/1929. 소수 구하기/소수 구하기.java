import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static boolean[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    arr = new boolean[m + 1];
    arr[0] = true;
    arr[1] = true;
    for (int i = 0; i < m; i++) {
      prime(i, m);
    }
    for (int i = 0; i <= m; i++) {
      if (arr[i] == false && i >= n) {
        bw.write(i + "\n");
      }
    }
    br.close();
    bw.close();
  }

  static void prime(int n, int m) {
    if (n < 2) {
      return;
    }
    if (arr[n] == false) {
      for (int i = 2; i * n <= m; i++) {
        arr[n * i] = true;
      }
    } else {
      return;
    }
  }
}
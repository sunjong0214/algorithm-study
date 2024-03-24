import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[] arr = new int[100005];
  static int[] D = new int[100005];
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int max = arr[0];
    D[0] = arr[0];
    for (int i = 1; i < N; i++) {
      D[i] = Math.max(D[i - 1] + arr[i], arr[i]);

      max = Math.max(max, D[i]);
    }
    System.out.println(max);
    br.close();
    bw.close();
  }
}
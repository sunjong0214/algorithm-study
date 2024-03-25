import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[] arr = new int[1005];
  static int[] D = new int[1005];
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    D[0] = 1;
    int maxLength = 1;
    for (int i = 1; i < N; i++) {
      D[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          D[i] = Math.max(D[i], D[j] + 1);
          maxLength = Math.max(maxLength, D[i]);
        }
      }
    }
    bw.write(maxLength + "\n");
    br.close();
    bw.close();
  }
}
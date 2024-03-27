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
      bw.write(st.nextToken() + " ");
      int n = st.countTokens();
      int[] arr = new int[n];
      for (int j = 0; j < n; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }
      int result = 0;
      for (int x = 0; x < n; x++) {
        for (int y = x + 1; y < n; y++) {
          if (arr[x] > arr[y]) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            result++;
          }
        }
      }
      bw.write(result + "\n");
    }
    br.close();
    bw.close();
  }
}
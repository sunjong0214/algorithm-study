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

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    int[] sum = new int[n];
    st = new StringTokenizer(br.readLine());
    arr[0] = Integer.parseInt(st.nextToken());
    sum[0] = arr[0];
    for (int i = 1; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum[i] = arr[i] + sum[i - 1];
    }
    for (int i = 0; i < m; i++) {
      int result = 0;
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 2;
      int y = Integer.parseInt(st.nextToken()) - 1;
      if (x >= 0) {
        result = sum[y] - sum[x];
      } else {
        result = sum[y];
      }
      bw.write(result + "\n");
    }
    br.close();
    bw.close();
  }
}
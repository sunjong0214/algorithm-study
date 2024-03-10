import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    StringBuilder str;

    long[] arr = new long[n];
    int i = 0;

    while (i < n) {
      if (!st.hasMoreTokens() && i < n) {
        st = new StringTokenizer(br.readLine());
      }
      String x;
      try {
        x = st.nextToken();
      } catch (Exception e) {
        continue;
      }
      str = new StringBuilder(x);
      arr[i++] = Long.parseLong(str.reverse().toString());
    }

    Arrays.sort(arr);

    for (long s : arr) {
      bw.write(s + "\n");
    }

    br.close();
    bw.close();
  }
}
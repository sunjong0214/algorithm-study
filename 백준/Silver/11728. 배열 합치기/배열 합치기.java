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

    int[] a = new int[n];
    int[] b = new int[m];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }
    int aIdx = 0;
    int bIdx = 0;
    int[] arr = new int[n + m];
    int rIdx = 0;
    while (aIdx + bIdx < n + m) {
      if (aIdx == n) {
        arr[rIdx++] = b[bIdx++];
        continue;
      } else if (bIdx == m) {
        arr[rIdx++] = a[aIdx++];
        continue;
      }
      if (a[aIdx] > b[bIdx]) {
        arr[rIdx++] = b[bIdx++];
      } else if (a[aIdx] == b[bIdx]) {
        arr[rIdx++] = b[bIdx++];
        arr[rIdx++] = a[aIdx++];
      } else {
        arr[rIdx++] = a[aIdx++];
      }
    }
    for (int x : arr) {
      bw.write(x + " ");
    }
    br.close();
    bw.close();
  }
}

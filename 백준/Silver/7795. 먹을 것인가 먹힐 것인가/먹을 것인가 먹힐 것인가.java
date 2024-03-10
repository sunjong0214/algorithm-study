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

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int aSize = Integer.parseInt(st.nextToken());
      int bSize = Integer.parseInt(st.nextToken());
      int result = 0;
      int[] A = new int[aSize];
      int[] B = new int[bSize];
      st = new StringTokenizer(br.readLine());
      for (int a = 0; a < aSize; a++) {
        A[a] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int b = 0; b < bSize; b++) {
        B[b] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(A);
      Arrays.sort(B);
      int aIdx = aSize - 1;
      int bIdx = bSize - 1;
      while (aIdx >= 0) {
        if (A[aIdx] > B[bIdx]) {
          aIdx--;
          result += bSize;
        } else {
          for (int j = bIdx; j >= 0; j--) {
            if (A[aIdx] > B[j]) {
              result += j + 1;
              break;
            }
            if (j == 0) {
              aIdx = 0;
            }
          }
          aIdx--;
        }
      }
      bw.write(result + "\n");
    }
    br.close();
    bw.close();
  }
}
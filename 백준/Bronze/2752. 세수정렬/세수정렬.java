import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] num = new int[3];
    int i = 0;
    while (st.hasMoreTokens()) {
      num[i++] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(num);
    for (int x : num) {
      bw.append((x+0) + " ");
    }
    br.close();
    bw.close();
  }
}
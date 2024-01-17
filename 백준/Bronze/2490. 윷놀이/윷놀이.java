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
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int x = 0;
      while (st.hasMoreTokens()) {
        if (Integer.parseInt(st.nextToken()) == 1) {
          x++;
        }
      }
      switch (x) {
        case 3:
          bw.append("A" + "\n");
          break;
        case 2:
          bw.append("B" + "\n");
          break;
        case 1:
          bw.append("C" + "\n");
          break;
        case 0:
          bw.append("D" + "\n");
          break;
        case 4:
          bw.append("E" + "\n");
          break;
      }
    }
    br.close();
    bw.close();
  }
}
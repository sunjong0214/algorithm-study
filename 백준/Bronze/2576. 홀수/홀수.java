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
    int max = 100;
    int sum = 0;
    for (int i = 0; i < 7; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x % 2 != 0) {
        if (max > x) {
          max = x;
        }
        sum += x;
      }
    }
    if (sum != 0) {
      bw.write(sum + "\n" + max);
    } else {
      bw.write(-1 + "");
    }
    br.close();
    bw.close();
  }
}
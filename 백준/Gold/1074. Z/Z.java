import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int x;
  static int y;
  static int r;
  static int c;
  static int idx;
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    idx = 1;
    for (int i = 0; i < n; i++) {
      idx *= 2;
    }
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    func(idx, r, c);
    System.out.println(result - 1);
    br.close();
    bw.close();
  }

  static void func(int index, int r, int c) {
    if (index == 0) {
      return;
    }
    int xTemp = index / 2;
    int yTemp = index / 2;
    if (xTemp <= r && yTemp <= c) {
      result += index * index - (index * index / 4);
      func(index / 2, r - xTemp, c - yTemp);
    } else if (xTemp <= r && yTemp > c) {
      result += (index * index) - 2 * (index * index / 4);
      func(index / 2, r - xTemp, c);
    } else if (xTemp > r && yTemp <= c) {
      result += (index * index) - 3 * (index * index / 4);
      func(index / 2, r, c - yTemp);
    } else {
      func(index / 2, r, c);
    }
  }
}
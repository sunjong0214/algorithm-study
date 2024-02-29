import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public String toString() {
      return x + " " + y + "\n";
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    Coordinate[] cdn = new Coordinate[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      cdn[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(cdn, (c1, c2) -> {
      int xDiff = c1.x - c2.x;
      if (xDiff == 0) {
        return c1.y - c2.y;
      }
      return xDiff;
    });

    for (int i = 0; i < N; i++) {
      System.out.print(cdn[i].toString());
    }
    br.close();
  }
}
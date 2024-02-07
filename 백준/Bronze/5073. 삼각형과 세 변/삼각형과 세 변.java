import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str;
    while (!(str = br.readLine()).equals("0 0 0")) {

      StringTokenizer st = new StringTokenizer(str);
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());

      int max = Math.max(Math.max(x, y), z);

      if (max >= x + y || max >= y + z || max >= z + x) {
        System.out.println("Invalid");
        continue;
      }
      if (x == y && y == z) {
        System.out.println("Equilateral");
      } else if (x == y || y == z || z == x) {
        System.out.println("Isosceles");
      } else if (x != y && y != z && z != x) {
        System.out.println("Scalene");
      }
    }
    br.close();
  }
}

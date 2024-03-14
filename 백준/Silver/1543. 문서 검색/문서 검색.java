import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String docs = br.readLine();
    String func = br.readLine();

    int result = 0;
    for (int i = 0; i < docs.length(); i++) {
      if (docs.charAt(i) == func.charAt(0)) {
        int idx = 0;
        for (int j = i; j < func.length() + i; j++) {
          if (idx == func.length() || j == docs.length() || docs.charAt(j) != func.charAt(idx)) {
            break;
          }
          if (idx == func.length() - 1) {
            i += func.length() - 1;
            result++;
          }
          idx++;
        }
      }
    }
    System.out.println(result);
  }
}
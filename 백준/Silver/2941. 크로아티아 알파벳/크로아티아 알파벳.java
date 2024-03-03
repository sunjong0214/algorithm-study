import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    int result = 0;
    for (int i = 0; i < str.length(); i++) {
      char x = str.charAt(i);
      if (i + 1 < str.length() && (x == 'c' || x == 's' || x == 'z')) {
        if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
          i++;
          result++;
          continue;
        }
      } else if (i + 1 < str.length() && x == 'd') {
        if (str.charAt(i + 1) == '-') {
          i++;
          result++;
          continue;
        } else if (i + 2 < str.length() && (str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=')) {
          i = i + 2;
          result++;
          continue;
        }
      } else if (i + 1 < str.length() && (x == 'n' || x == 'l')) {
        if (str.charAt(i + 1) == 'j') {
          i++;
          result++;
          continue;
        }
      }
      result++;
    }
    System.out.println(result);
    br.close();
  }
}

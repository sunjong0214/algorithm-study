import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (n-- > 0) {
      Stack<Character> stack = new Stack<>();
      String vps = br.readLine();
      int len = 0;
      while (len < vps.length()) {
        if (vps.charAt(len) == '(')
          stack.push(vps.charAt(len));
        else {
          if (stack.isEmpty()) {
            sb.append("NO\n");
            break;
          }
          stack.pop();
        }
        len++;
      }
      if (stack.isEmpty() && len == vps.length()) {
        sb.append("YES\n");
      } else if (len == vps.length()) {
        sb.append("NO\n");
      }
    }
    sb.deleteCharAt(sb.length() -1);
    System.out.println(sb);
    br.close();
  }
}

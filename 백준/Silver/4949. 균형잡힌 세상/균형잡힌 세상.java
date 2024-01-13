import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      Stack<Character> stack = new Stack<>();
      String str = br.readLine();
      int i = 0;
      boolean yes = true;
      if (str.charAt(0) == '.') {
        break;
      }
      while (str.charAt(i) != '.') {
        if (str.charAt(i) == '(') {
          stack.push('(');
        } else if (str.charAt(i) == '[') {
          stack.push('[');
        } else if (str.charAt(i) == ')') {
          if (stack.isEmpty() == true ||stack.peek() != '(') {
            yes = !yes;
            break;
          }
          stack.pop();
        } else if (str.charAt(i) == ']') {
          if (stack.isEmpty() == true || stack.peek() != '[') {
            yes = !yes;
            break;
          }
          stack.pop();
        }
        i++;
      }
      if (yes == true && stack.isEmpty() == true)
        System.out.println("yes");
      else
        System.out.println("no");
    }
    br.close();
  }
}
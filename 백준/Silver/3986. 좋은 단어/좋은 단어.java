import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // 테스트 횟수
    String s;
    int result = 0;
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      if (s.length() % 2 == 1) {
        continue;
      }
      Stack<Character> stack = new Stack<>();
      int j = 1;
      stack.push(s.charAt(0));
      while (j != s.length()) {
        if (stack.isEmpty() == true || stack.peek() != s.charAt(j)) {
          stack.push(s.charAt(j));
        } else if (stack.peek() == s.charAt(j)) {
          stack.pop();
        }
        j++;
      }
      if (stack.isEmpty() == true) {
        result++;
      }
    }
    System.out.println(result);
  }
}

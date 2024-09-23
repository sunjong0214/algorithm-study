import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Stack<int[]> stack = new Stack<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      int tower = Integer.parseInt(st.nextToken());
      if (stack.isEmpty()) {
        sb.append("0 ");
      }
      while (!stack.isEmpty()) {
        if (stack.peek()[1] > tower) {
          sb.append(stack.peek()[0] + " ");
          break;
        } else {
          stack.pop();
          if (stack.isEmpty()) {
            sb.append("0 ");
            break;
          }
        }
      }
      stack.push(new int[] {i, tower});
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb);
    br.close();
  }
}

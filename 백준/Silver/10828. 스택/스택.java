import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine()); // 량
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    while (n-- != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      switch (st.nextToken()) {
        case "push":
          stack.push(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          if (stack.isEmpty()) {
            sb.append(-1 + "\n");
            break;
          }
          sb.append(stack.pop() + "\n");
          break;
        case "size":
          sb.append(stack.size() + "\n");
          break;
        case "empty":
          if (stack.isEmpty()) {
            sb.append(1 + "\n");
            break;
          }
          sb.append(0 + "\n");
          break;
        case "top":
          if (stack.isEmpty()) {
            sb.append(-1 + "\n");
            break;
          }
          sb.append(stack.peek() + "\n");
          break;
      }
    }
    bw.write(sb + "");
    br.close();
    bw.close();
  }
}
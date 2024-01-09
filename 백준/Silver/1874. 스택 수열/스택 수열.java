import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>(); // 1, 2, 5, 7,
    Stack<Integer> result = new Stack<>(); // 4, 3, 6, 8
    StringBuilder sb = new StringBuilder();
    int x = 1;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());// 8, x = 7
    }
    int i = 0;
    while (true) {
      if (i >= n) {
        break;
      }
      if (stack.empty()) {
        stack.push(x);
        sb.append("+\n");
        x++;
      } else if (arr[i] > stack.peek()) { // 1 2 3 4
        stack.push(x);
        sb.append("+\n");
        x++;
      } else if (arr[i] == stack.peek()) {
        if (stack.peek() != arr[i]) {
          sb = new StringBuilder();
          sb.append("NO");
          break;
        }
        result.push(stack.pop());
        sb.append("-\n");
        i++;
      } else if (arr[i] < result.peek()) {
        if (stack.peek() != arr[i]) {
          sb = new StringBuilder();
          sb.append("NO");
          break;
        }
        result.push(stack.pop());
        sb.append("-\n");
        i++;
      }

    }
    bw.write(sb + "");
    br.close();
    bw.close();
  }
}
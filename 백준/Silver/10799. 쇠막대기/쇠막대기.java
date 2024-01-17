import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    Stack<Character> stack = new Stack<>();
    stack.push(input.charAt(0));
    int pipe = 1;
    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) == '(') {
        stack.push(input.charAt(i));
        pipe++;
      } else if (input.charAt(i) == ')') {
        if (input.charAt(i-1) == '(') { // 레이저
          stack.pop();
          pipe--;
          pipe = pipe + stack.size();
        } else {
          stack.pop();
        }
      }
    }
    bw.write(pipe + "");
    br.close();
    bw.close();
  }
}
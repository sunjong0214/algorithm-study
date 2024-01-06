import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] arr = br.readLine().toCharArray();
    int n = Integer.parseInt(br.readLine());
    Stack<Character> stack = new Stack<Character>();
    for (Character str : arr) {
      stack.push(str);
    }
    Stack<Character> cursor = new Stack<>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      String x = br.readLine();
      if (x.equals("L")) {
        try {
          cursor.push(stack.pop());
        } catch (Exception e) {
          continue;
        }
      } else if (x.equals("D")) {
        try {
          stack.push(cursor.pop());
        } catch (Exception e) {
          continue;
        }
      } else if (x.equals("B")) {
        try {
          stack.pop();
        } catch (Exception e) {
          continue;
        }
      } else {
        st = new StringTokenizer(x, "P ");
        stack.push(st.nextToken().charAt(0));
      }
    }
    while(!stack.empty()) {
      cursor.push(stack.pop());
    }
    StringBuilder str = new StringBuilder();
    while(!cursor.empty()) {
      str.append(cursor.pop());
    }
    System.out.println(str);
    br.close();
    bw.close();
  }
}

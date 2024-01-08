import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    char[] temp;
       Stack<Character> str = new Stack<>();
    Stack<Character> cursor = new Stack<>();

    for (int i = 0; i < n; i++) {
      temp = br.readLine().toCharArray();
      int size = temp.length;
      for (int j = 0; j < size; j++) {
        // if (temp[j] == '<') {
        // cursor.push(str.pop());
        // } else if (temp[j] == '>') {
        // str.push(cursor.pop());
        // } else if (temp[j] == '-') {
        // str.pop();
        // }
        switch (temp[j]) {
          case '<':
            try {
              cursor.push(str.pop());
            } catch (Exception e) {
              break;
            }
            break;
          case '>':
            try {
              str.push(cursor.pop());
            } catch (Exception e) {
              break;
            }
            break;
          case '-':
            try {
              str.pop();
            } catch (Exception e) {
              break;
            }
            break;
          default:
            str.push(temp[j]);
            break;
        }
      }
      while (!str.empty()) {
        cursor.push(str.pop());
      }
      StringBuilder sb = new StringBuilder();
      while (!cursor.empty()) {
        sb.append(cursor.pop());
      }
      System.out.println(sb);
    }
    br.close();
  }
}
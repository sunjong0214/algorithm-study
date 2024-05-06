import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            boolean is = true;
            if (str.equals(".")) {
                break;
            }
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == '.') {
                    break;
                }
                if (str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == '[') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        is = false;
                        break;
                    }
                    stack.pop();
                } else if (str.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        is = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty() && is) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        br.close();
        bw.close();
    }
}

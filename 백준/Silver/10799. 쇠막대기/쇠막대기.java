
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        boolean b = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (stack.peek() == '(' && b) {
                    stack.pop();
                    b = false;
                    result += stack.size();
                } else {
                    stack.pop();
                    result++;
                }
            } else {
                b = true;
                stack.push(str.charAt(i));
            }
        }
        System.out.println(result);
        br.close();
        bw.close();
    }
}

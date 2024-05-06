
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (stack.isEmpty() && str.charAt(j) == ')') {
                    stack.push(')');
                    break;
                }
                if (str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
        bw.close();
    }
}

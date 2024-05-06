
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'A') {
                    if (!stack.isEmpty() && stack.peek() == 'A') {
                        stack.pop();
                        continue;
                    }
                    stack.push(str.charAt(j));
                } else if (str.charAt(j) == 'B') {
                    if (!stack.isEmpty() && stack.peek() == 'B') {
                        stack.pop();
                        continue;
                    }
                    stack.push(str.charAt(j));
                }
            }
            if (stack.isEmpty()) {
                result++;
            }
        }
        System.out.println(result);
    }
}

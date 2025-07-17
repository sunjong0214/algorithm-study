import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        Map<Character, BigDecimal> map = new HashMap<>();
        Stack<BigDecimal> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (c == '*' || c == '/' || c == '+' || c == '-') {
                BigDecimal post = stack.pop();
                BigDecimal pre = stack.pop();
                if (c == '*') {
                    stack.push(pre.multiply(post));
                } else if (c == '/') {
                    stack.push(pre.divide(post, 2, RoundingMode.DOWN));
                } else if (c == '+') {
                    stack.push(pre.add(post));
                } else {
                    stack.push(pre.subtract(post));
                }
            } else {
                if (!map.containsKey(c)) {
                    map.put(c, BigDecimal.valueOf(Long.parseLong(br.readLine())));
                }
                stack.push(map.get(c));
            }
        }
        bw.write(stack.pop().setScale(2) + "\n");
        br.close();
        bw.close();
    }
}
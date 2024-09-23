import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /**
     * Stack / int n /
     * 반복문
     * -> 입력된 숫자보다 현재 index가 작으면 맞는 숫자 나올 때까지 +
     * 만약 같으면 pop, 작으면 stack에서 같을 값이 나올 때까지 -, 만약 -하다 더 큰 숫자가 나오면 No
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        int N = n;
        StringBuilder sb = new StringBuilder();
        while (N-- != 0) {
            int num = Integer.parseInt(br.readLine());
            while (num >= idx) {
                stack.push(idx);
                sb.append("+\n");
                idx++;
            }
            if (stack.peek() != num) {
                sb = new StringBuilder("NO");
                break;
            }
            stack.pop();
            sb.append("-\n");
        }
        bw.write(sb + "");
        br.close();
        bw.close();
    }
}

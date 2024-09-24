import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int[] num = new int[]{Integer.parseInt(br.readLine()), 0};
            if (!stack.isEmpty() && num[0] >= stack.peek()[0]) {
                while (!stack.isEmpty()) {
                    if (stack.peek()[1] != 0 && stack.peek()[0] < num[0]) {
                        sum += stack.peek()[1] + 1;
                    } else {
                        sum++;
                    }
                    if (num[0] < stack.peek()[0]) {
                        break;
                    }
                    if (num[0] == stack.peek()[0]) {
                        num[1] = stack.peek()[1] + 1;
                        if (stack.peek()[1] != 0) {
                            sum += stack.peek()[1];
                        }
                    }
                    stack.pop();
                }
            } else if (!stack.isEmpty() && num[0] < stack.peek()[0]) {
                sum++;
            }
            stack.push(num);
        }
        bw.write(sum + " ");
        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>();
        long sum = 0L;
        for (long i = 0L; i < n; i++) {
            long building = Long.parseLong(br.readLine());
            if (!stack.isEmpty() && stack.peek() > building) {
                sum += stack.size();
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() > building) {
                        sum += stack.size();
                        break;
                    }
                    stack.pop();
                }
            }
            stack.push(building);
        }
        bw.write(sum + "");
        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // peek이 작으면 넓이 계산
            // -> stack.size * num
            // peek이 크면 넣기

            Stack<Integer> stack = new Stack<>();
            long max = 0L;
            for (int i = 0; i < n; i++) {
                int num = arr[i];
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                int peekNum = stack.peek();
                if (arr[peekNum] > num) {
                    while (!stack.isEmpty()) {
                        if (arr[stack.peek()] < num)
                            break;
                        int height = arr[stack.pop()];
                        int width = i;
                        if (!stack.isEmpty())
                            width = i - 1 - stack.peek();
                        max = Math.max((long) height * width, max);
                    }
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int height = arr[stack.pop()];
                int width = n;
                if (!stack.isEmpty())
                    width = n - 1 - stack.peek();
                max = Math.max((long) height * width, max);
            }

            bw.write(max + "\n");
        }
        br.close();
        bw.close();
    }
}
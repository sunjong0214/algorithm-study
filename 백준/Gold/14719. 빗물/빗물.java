import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        int highest = 0;
        // 하나씩 pop 하다 제일 큰 높이보다 크거나 같을 때 -> 뒤는 이제 신경 X
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (highest < pop) {
                while (!temp.isEmpty()) {
                    result += (highest - temp.pop());
                }
            }
            temp.push(pop);
            highest = Math.max(highest, pop);
        }

        if (!temp.isEmpty()) {
            highest = temp.pop();
            while (!temp.isEmpty()) {
                Integer poll = temp.pop();
                if (highest > poll) {
                    result += (highest - poll);
                }
                highest = Math.max(highest, poll);
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
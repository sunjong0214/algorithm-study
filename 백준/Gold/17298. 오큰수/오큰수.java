import java.io.*;
import java.util.*;

public class Main {
    /**
     * 만약 입력값이 크면 오큰수가 정해진 값은 pop 하면서 출력
     * 입력값이 작으면 push 후 오큰수가 나타날 때까지 대기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int[] num = new int[]{Integer.parseInt(st.nextToken()), i};
            if (!stack.isEmpty() && num[0] > stack.peek()[0]) {
                while (!stack.isEmpty()) {
                    if (num[0] <= stack.peek()[0]) {
                        break;
                    }
                    arr[stack.pop()[1]] = num[0];
                }
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()[1]] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i + " ");
        }
        bw.write(sb + "");
        br.close();
        bw.close();
    }
}

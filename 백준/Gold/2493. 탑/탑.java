import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stack.push(new int[]{Integer.parseInt(st.nextToken()), i});
        }


        int[] topIdx = new int[n];
        Stack<int[]> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            temp.push(pop);
            if (stack.isEmpty()) {
                break;
            }
            while (stack.peek()[0] > temp.peek()[0]) {
                int[] tPop = temp.pop();
                topIdx[tPop[1]] = stack.size();
                if (temp.isEmpty()) break;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(topIdx[i] + " ");
        }
        br.close();
        bw.close();
    }
}
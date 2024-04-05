import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> list = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (n-- > 0) {
            for (int i = 0; i < k - 1; i++) {
                list.offer(list.pop());
            }
            sb.append(list.pop()).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(">");
        System.out.println(sb);
        br.close();
    }
}

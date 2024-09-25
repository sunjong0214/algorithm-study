import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                dq.push(num);
            } else if (cmd.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                dq.offer(num);
            } else if (cmd.equals("pop_front")) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(dq.removeFirst() + "\n");
            } else if (cmd.equals("pop_back")) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(dq.removeLast() + "\n");
            } else if (cmd.equals("size")) {
                bw.write(dq.size() + "\n");
            } else if (cmd.equals("empty")) {
                if (dq.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (cmd.equals("front")) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(dq.peekFirst() + "\n");
            } else if (cmd.equals("back")) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(dq.peekLast() + "\n");
            }
        }
        br.close();
        bw.close();
    }
}


import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= num; i++) {
            q.offer(i);
        }
        while (q.size() > 1) {
            q.poll();
            if (q.size() == 1) {
                break;
            }
            q.offer(q.poll());
        }
        bw.write(q.poll() + "");
        br.close();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }
        st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < m; i++) {
            int index = 0;
            int num = Integer.parseInt(st.nextToken());
            Object[] array = dq.toArray();
            for (int j = 0; j < array.length; j++) {
                if (array[j].equals(num)) {
                    index = j;
                    break;
                }
            }
            int size = dq.size();
            if (size / 2 < index) {
                // 뒤부터
                while (true) {
                    if (dq.peekFirst() == num) {
                        dq.removeFirst();
                        break;
                    }
                    dq.addFirst(dq.removeLast());
                    result++;
                }
            } else {
                // 앞부터
                while (true) {
                    if (dq.peekFirst() == num) {
                        dq.removeFirst();
                        break;
                    }
                    dq.addLast(dq.removeFirst());
                    result++;
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}

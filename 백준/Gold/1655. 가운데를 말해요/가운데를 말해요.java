import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int minSize = min.size();
            int maxSize = max.size();
            if (i == 0) {
                max.offer(num);
            } else if (i == 1) {
                if (max.peek() >= num) {
                    min.offer(max.poll());
                    max.offer(num);
                } else {
                    min.offer(num);
                }
            } else {
                if (maxSize > minSize) {
                    // min q 에서 확인 후 옮기기
                    if (max.peek() > num) {
                        min.offer(max.poll());
                        max.offer(num);
                    } else
                        min.offer(num);
                } else if (minSize >= maxSize) {
                    // max q에서 확인 후 옮기기
                    if (max.size() != 0 && min.peek() < num) {
                        max.offer(min.poll());
                        min.offer(num);
                    } else
                        max.offer(num);
                }
            }
            if (i == 0) bw.write(max.peek() + "\n");
            else bw.write(Math.min(max.peek(), min.peek()) + "\n");
        }
        br.close();
        bw.close();
    }
}
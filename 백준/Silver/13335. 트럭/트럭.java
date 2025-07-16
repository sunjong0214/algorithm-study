import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return idx - o.idx;
        }
    }

    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(0, Integer.parseInt(st.nextToken())));
        }

        int sec = 0;
        Queue<Node> q = new LinkedList<>();
        while (true) {
            if (list.isEmpty() && q.isEmpty()) {
                break;
            }
            move(q, w);
            addQ(list, l, q);
            sec++;
        }
        bw.write(sec + "\n");
        br.close();
        bw.close();
    }

    private static void addQ(List<Node> list, int l, Queue<Node> q) {
        if (!list.isEmpty()) {
            Node node = list.get(0);
            if (sum + node.num <= l) {
                Node remove = list.remove(0);
                q.offer(remove);
                remove.idx = 1;
                sum += node.num;
            }
        }
    }

    private static void move(Queue<Node> q, int w) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Node poll = q.poll();
            poll.idx++;
            if (poll.idx <= w) {
                q.offer(poll);
            } else {
                sum -= poll.num;
            }
        }
    }
}
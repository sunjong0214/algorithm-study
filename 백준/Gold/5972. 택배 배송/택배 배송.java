import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int from;
        int cow;

        public Node(int from, int cow) {
            this.from = from;
            this.cow = cow;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Node>> graph = new ArrayList<>();
        int[] min = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            min[i] = 50000001;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cow = Integer.parseInt(st.nextToken());
            graph.get(to).add(new Node(from, cow));
            graph.get(from).add(new Node(to, cow));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.cow - b.cow);
        min[1] = 0;
        q.add(new Node(1, 0));

        while(!q.isEmpty()) {
            Node poll = q.poll();
            List<Node> nodes = graph.get(poll.from);
            for (int j = 0; j < nodes.size(); j++) {
                Node node = nodes.get(j);
                if (min[node.from] > min[poll.from] + node.cow) {
                    min[node.from] = min[poll.from] + node.cow;
                    q.add(new Node(node.from, min[node.from]));
                }
            }
        }
        bw.write(min[n] + "");
        br.close();
        bw.close();
    }
}

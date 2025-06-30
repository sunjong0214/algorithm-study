import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph.get(to).add(from);
            graph.get(from).add(to);
        }
        Stack<Integer> dfs = new Stack<>();
        Queue<Integer> bfs = new LinkedList<>();
        dfs.push(startNode);
        bfs.offer(startNode);
        for (int i = 0; i < n + 1; i++) {
            graph.get(i).sort((a, b) -> a - b);
        }

        int[] dfsResult = new int[n];
        boolean[] visit = new boolean[n + 1];
        int idx = 0;
        while (!dfs.isEmpty() && n > idx) {
            int nodeIdx = dfs.pop();
            if (visit[nodeIdx]) {
                continue;
            }
            visit[nodeIdx] = true;
            dfsResult[idx++] = nodeIdx;
            List<Integer> nodes = graph.get(nodeIdx);
            for (int i = nodes.size() - 1; i >= 0; i--) {
                int neighborNode = nodes.get(i);
                if (!visit[neighborNode]) { // 방문하지 않은 노드만
                    dfs.push(neighborNode); // 스택에 추가한다.
                }
            }
        }
        for (int num : dfsResult) {
            if (num == 0) {
                break;
            }
            bw.write(num + " ");
        }
        bw.write("\n");

        int[] bfsResult = new int[n];
        visit = new boolean[n + 1];
        visit[startNode] = true;
        idx = 0;
        while (!bfs.isEmpty() && n > idx) {
            int nodeIdx = bfsResult[idx++] = bfs.poll();
            List<Integer> nodes = graph.get(nodeIdx);
            for (int i = 0; i < nodes.size(); i++) {
                if (visit[nodes.get(i)]) {
                    continue;
                }
                bfs.offer(nodes.get(i));
                visit[nodes.get(i)] = true;
            }
        }
        for (int num : bfsResult) {
            if (num == 0) {
                break;
            }
            bw.write(num + " ");
        }
        bw.write("\n");

        br.close();
        bw.close();
    }
}

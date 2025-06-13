import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 셋팅, 유사도 셋티어
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());
            graph.get(p).add(new int[]{q, usado});
            graph.get(q).add(new int[]{p, usado});
        }

        // 실제 계산 로직
        for (int i = 0; i < Q; i++) {
            boolean[] visited = new boolean[N + 1];
            result = 0;
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            List<int[]> list = graph.get(v);
            visited[v] = true;
            // bfs
            func(graph, list, visited, k);
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }

    private static void func(List<List<int[]>> graph, List<int[]> list, boolean[] visited, int k) {
        for (int j = 0; j < list.size(); j++) {
            if (visited[list.get(j)[0]] || list.get(j)[1] < k) {
                continue;
            }
            result++;
            visited[list.get(j)[0]] = true;
            func(graph, graph.get(list.get(j)[0]), visited, k);
        }
    }
}
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
    static int n, k;
    static boolean[] visit;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                queue.add(i);
                visit[i] = true;
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    for (int j = 0; j < graph[poll].size(); j++) {
                        if (!visit[graph[poll].get(j)]) {
                            queue.add(graph[poll].get(j));
                            visit[graph[poll].get(j)] = true;
                        }
                    }
                }
                result++;
            }
        }
        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }
}
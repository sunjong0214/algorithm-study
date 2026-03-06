import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        Stack<int[]> stack = new Stack<>();
        visited = new boolean[n + 1];

        stack.push(new int[]{1, 0});
        visited[1] = true;

        int cnt = 0;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            ArrayList<Integer> list = graph[pop[0]];

            if (pop[1] >= 2) continue;

            for (int v : list) {
                if (visited[v]) continue;
                stack.push(new int[]{v, pop[1] + 1});
                visited[v] = true;
                cnt++;
            }
        }

        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
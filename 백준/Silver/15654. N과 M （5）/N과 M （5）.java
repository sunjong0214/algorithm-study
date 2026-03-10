import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static boolean[] visited;
    static int[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        select = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        back(0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void back(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            select[depth] = nums[i];
            visited[i] = true;
            back(depth + 1);
            visited[i] = false;
        }

    }
}
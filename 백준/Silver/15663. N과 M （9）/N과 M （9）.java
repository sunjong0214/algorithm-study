import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] nums;
    static boolean[] select;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        nums = new int[m];
        select = new boolean[n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        comb(0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void comb(int depth) {
        if (depth == m) {
            StringBuilder tsb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                tsb.append(nums[i]).append(" ");
            }
            tsb.append("\n");
            if (set.add(tsb.toString()))
                sb.append(tsb);
            return;
        }
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (select[i]) continue;
            nums[depth] = num;
            select[i] = true;
            comb(depth + 1);
            select[i] = false;
        }
    }
}
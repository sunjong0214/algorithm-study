import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cnt = new int[101];
        boolean[] isVisited = new boolean[101];
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(u, v);
        }

        q.offer(1);
        isVisited[1] = true;
    
        loop:
        while(!q.isEmpty()) {
            int idx = q.poll();

            for (int i = 1; i <= 6; i++) {
                if (idx + i > 100) continue;
                if (isVisited[idx + i]) continue;

                if (map.get(idx + i) != null) {
                    if (isVisited[map.get(idx + i)]) continue;
                    q.offer(map.get(idx + i));
                    isVisited[map.get(idx + i)] = true;
                    cnt[map.get(idx + i)] = cnt[idx] + 1; 
                    if (map.get(idx + i) == 100) {
                        bw.write(String.valueOf(cnt[map.get(idx + i)]));
                        break loop;
                    }
                } else {
                    isVisited[idx + i] = true;
                    q.offer(idx + i);
                    cnt[idx + i] = cnt[idx] + 1;
                    if (idx + i == 100) {
                        bw.write(String.valueOf(cnt[idx + i]));
                        break loop;
                    }
                }
            }
        }
        
        br.close();
        bw.close();
    }
}
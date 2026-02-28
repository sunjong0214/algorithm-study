import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 맨 밑줄 확인 -> .이 아니면 bfs -> bfs 시 뿌요면 -> 위에 있는거 아래로 내리기 -> 처음부터 시작
        // 뿌요 못하면 -> 다음 인덱스 확인
        // 문제 : 내리는 걸 어떻게 할까?? -> 링크드 리스트 사용해서 중간에서 삭제ㅐ?
        // bfs 돌면서 좌표 저장해놓고 (visited)에 하나씩 팝해서 해당 좌표 삭제?

        List<List<Character>> ppuyo = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            ppuyo.add(new LinkedList<>());
        }

        for (int j = 0; j < 12; j++) {
            String str = br.readLine();
            for (int i = 0; i < 6; i++) {
                ppuyo.get(i).add(str.charAt(i));
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;
        boolean flag = true;
        while (flag) {
            boolean[][] visited = new boolean[6][12];
            Queue<int[]> q = new LinkedList<>();
            List<int[]> removeList = new ArrayList<>();
            flag = false;
            for (int depth = 11; depth >= 0; depth--) {
                for (int i = 0; i < 6; i++) {
                    if (ppuyo.get(i).isEmpty()) continue;
                    if (ppuyo.get(i).get(depth) == '.') continue;
                    if (visited[i][depth]) continue;
                    //bfs
                    char c = ppuyo.get(i).get(depth);
                    visited[i][depth] = true;
                    removeList.add(new int[]{i, depth});
                    q.offer(new int[]{i, depth});
                    while (!q.isEmpty()) {
                        int[] poll = q.poll();

                        for (int j = 0; j < 4; j++) {
                            int cx = poll[0] + dx[j];
                            int cy = poll[1] + dy[j];
                            if (cx < 0 || cx >= 6 || cy < 0 || cy > depth) continue;
                            if (visited[cx][cy]) continue;
                            char t = ppuyo.get(cx).get(cy);
                            if (t == '.' || t != c) continue;
                            q.offer(new int[]{cx, cy});
                            visited[cx][cy] = true;
                            removeList.add(new int[]{cx, cy});
                        }
                    }
                    if (removeList.size() >= 4) {
                        flag = true;
                        while (!removeList.isEmpty()) {
                            int[] rem = removeList.remove(removeList.size() - 1);
                            ppuyo.get(rem[0]).remove(rem[1]);
                            ppuyo.get(rem[0]).add(rem[1], '.');
                        }
                    } else removeList.clear();
                }
            }
            if (flag) cnt++;
            // 다 땡기기
            for (int i = 0; i < 6; i++) {
                List<Character> list = ppuyo.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 12; j++) {
                    sb.append(list.get(j));
                }
                StringTokenizer st = new StringTokenizer(sb.toString(), ".");
                list.clear();
                while (st.hasMoreTokens()) {
                    String s = st.nextToken();
                    for (int j = 0; j < s.length(); j++) {
                        list.add(s.charAt(j));
                    }
                }
                int size = list.size();
                for (int j = 0; j < 12 - size; j++) {
                    list.add(0, '.');
                }
            }
        }

        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
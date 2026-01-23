import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int gameCnt = 0;
        if (game.equals("Y")) gameCnt = 1;
        else if (game.equals("F")) gameCnt = 2;
        else gameCnt = 3;
        Set<String> set = new HashSet<>();

        // map은 중복검사용도 입력이 들어오면 cnt 증가시켜서 인원 차면 다음으로
        int flag = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (!set.contains(name)) {
                set.add(name);
                flag++;
            }
            if (flag == gameCnt) {
                result++;
                flag = 0;
            }
        }

        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }
}
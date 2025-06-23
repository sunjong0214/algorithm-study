import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Belt {
        int negoodo;
        boolean robot;

        public Belt(int negoodo) {
            this.negoodo = negoodo;
            this.robot = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int beltSize = 2 * N;

        // LinkedList 대신 ArrayList 사용 (get()이 O(1)이므로)
        ArrayList<Belt> belt = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < beltSize; i++) {
            belt.add(new Belt(Integer.parseInt(st.nextToken())));
        }

        int stage = 0;
        int zeroCount = 0;

        while (zeroCount < K) {
            stage++;

            // 1. 벨트 회전 (실제 데이터 이동 대신 인덱스 조작)
            // 마지막 요소를 맨 앞으로 가져옴
            belt.add(0, belt.remove(beltSize - 1));

            // 회전 후 로봇이 내리는 위치(N-1)에 도달하면 즉시 내림
            if (belt.get(N - 1).robot) {
                belt.get(N - 1).robot = false;
            }

            // 2. 로봇 이동
            for (int i = N - 2; i >= 0; i--) {
                Belt currentBelt = belt.get(i);
                Belt nextBelt = belt.get(i + 1);

                if (currentBelt.robot && !nextBelt.robot && nextBelt.negoodo >= 1) {
                    currentBelt.robot = false;
                    nextBelt.robot = true;
                    nextBelt.negoodo--;
                    if (nextBelt.negoodo == 0) {
                        zeroCount++;
                    }
                }
            }

            // 이동 후 로봇이 내리는 위치(N-1)에 도달하면 즉시 내림
            if (belt.get(N - 1).robot) {
                belt.get(N - 1).robot = false;
            }

            // 3. 올리는 위치에 로봇 올리기
            Belt firstBelt = belt.get(0);
            if (firstBelt.negoodo > 0) {
                firstBelt.robot = true;
                firstBelt.negoodo--;
                if (firstBelt.negoodo == 0) {
                    zeroCount++;
                }
            }
            
            // 4. 종료 조건 확인 (매번 전체를 순회하는 대신, 내구도가 0이 될 때마다 zeroCount를 1씩 증가)
            // 이 방식이 더 효율적입니다.
            if (zeroCount >= K) {
                break;
            }
        }

        bw.write(stage + "");
        br.close();
        bw.close();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Pillar {
        int idx;
        int area;

        Pillar(int idx, int area) {
            this.idx = idx;
            this.area = area;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Pillar> pillars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pillars.add(new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        pillars.sort((a, b) -> a.idx - b.idx);

        int result = 0;
        while (!pillars.isEmpty()) {
            Pillar pillar = pillars.remove(0);
            Stack<Pillar> temp = new Stack<>();
            temp.push(pillar);
            while (!pillars.isEmpty()) {
                if (pillar.area < pillars.get(0).area) {
                    result += (pillar.area * (pillars.get(0).idx - pillar.idx));
                    temp.clear();
                    break;
                } else {
                    temp.push(pillars.remove(0));
                }
            }
            if (!temp.isEmpty()) {
                result += pillar.area;
            }
            while (!temp.isEmpty()) {
                Pillar remove = temp.pop();
                while (!temp.isEmpty()) {
                    if (remove.area > temp.peek().area) {
                        temp.pop();
                    } else {
                        break;
                    }
                }
                if (!temp.isEmpty())
                    result += (remove.area * (remove.idx - temp.peek().idx));
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
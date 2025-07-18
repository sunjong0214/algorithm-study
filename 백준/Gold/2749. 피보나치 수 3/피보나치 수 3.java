import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int pre;
    static int post;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long n = Long.parseLong(br.readLine());
        pre = 0;
        post = 1;

        int cnt = 0;
        while (true) {
            cnt++;
            int temp = post;
            post = (pre % 1000000) + (post % 1000000);
            pre = temp % 1000000;
            if (post == 1 && pre == 0) {
                break;
            }
        }
        n = n % cnt;
        for (int i = 3; i <= n + 1; i++) {
            int temp = post;
            post = (pre % 1000000) + (post % 1000000);
            pre = temp % 1000000;
        }

        bw.write((post % 1000000) + "\n");
        br.close();
        bw.close();
    }
}
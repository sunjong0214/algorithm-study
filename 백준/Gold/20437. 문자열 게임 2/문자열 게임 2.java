import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = 0;
            int[] arr = new int[26];
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'a']++;
            }

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int check = 0;
                if (arr[c - 'a'] < k) {
                    continue;
                }
                for (int z = j; z < str.length(); z++) {
                    if (c == str.charAt(z)) {
                        check++;
                    }
                    if (check == k) {
                        min = Math.min(min, z - j + 1);
                        max = Math.max(max, z - j + 1);
                        break;
                    }
                }
            }
            if (max == 0) {
                bw.write(-1 + "\n");
            } else {
                bw.write(min + " " + max + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
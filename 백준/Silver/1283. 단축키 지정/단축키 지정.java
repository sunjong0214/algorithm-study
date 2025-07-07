import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            boolean flag = false;
            int idx = 0;
            char put = 0;
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                char c = 0;
                if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
                    c = (char) (s.charAt(0) + 32);
                } else {
                    c = s.charAt(0);
                }
                if (map.get(c) == null) {
                    flag = true;
                    map.put(c,
                            new StringBuilder(str).insert(idx, "[").insert(idx + 2, "]").toString());
                    put = c;
                    break;
                }
                idx += s.length() + 1;
            }
            if (!flag) {
                st = new StringTokenizer(str);
                idx = 0;
                while (st.hasMoreTokens() && put == 0) {
                    String s = st.nextToken();
                    for (int z = 1; z < s.length(); z++) {
                        char c = 0;
                        if (s.charAt(z) >= 'A' && s.charAt(z) <= 'Z') {
                            c = (char) (s.charAt(z) + 32);
                        } else {
                            c = s.charAt(z);
                        }
                        if (map.get(c) == null) {
                            map.put(c,
                                    new StringBuilder(str).insert(idx + z, "[").insert(idx + z + 2, "]").toString());
                            put = c;
                            break;
                        }
                    }
                    idx += s.length() + 1;
                }
            }
            if (put == 0) {
                bw.write(str + "\n");
            } else {
                bw.write(map.get(put) + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
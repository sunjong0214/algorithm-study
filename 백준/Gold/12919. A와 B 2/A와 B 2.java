import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String t = br.readLine();

        result = 0;
        func(s, t);

        bw.write(result + "");
        br.close();
        bw.close();
    }

    private static void func(String s, String t) {
        if (t.equals(s)) {
            result = 1;
            return;
        }
        if (s.length() >= t.length()) {
            return;
        }
        if (t.endsWith("A")) func(s, t.substring(0, t.length() -1));
        if (t.startsWith("B")) func(s, new StringBuffer(t.substring(1)).reverse().toString());
    }
}
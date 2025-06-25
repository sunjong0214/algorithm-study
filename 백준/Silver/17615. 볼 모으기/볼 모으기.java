import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int length;
    static String fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        fire = br.readLine();
        length = fire.length();

        asc('B');
        asc('R');
        desc('B');
        desc('R');

        bw.write(min + "");
        br.close();
        bw.close();
    }

    private static void desc(char target) {
        boolean check = false;
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (!check && fire.charAt(i) != target) {
                check = true;
            }
            if (check && fire.charAt(i) == target) {
                count++;
            }
        }
        min = Math.min(min, count);
    }

    private static void asc(char target) {
        boolean check = false;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (!check && fire.charAt(i) != target) {
                check = true;
            }
            if (check && fire.charAt(i) == target) {
                count++;
            }
        }
        min = Math.min(min, count);
    }
}
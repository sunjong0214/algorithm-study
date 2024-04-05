import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> password = new Stack<>();
        Stack<Character> temp = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char log = str.charAt(j);
                if (log == '<' && !password.isEmpty()) temp.push(password.pop());
                else if (log == '>' && !temp.isEmpty()) password.push(temp.pop());
                else if (log == '-' && !password.isEmpty()) password.pop();
                else  if (log != '<' && log != '>' && log != '-') password.push(log);
            }
            while (!password.isEmpty()) temp.push(password.pop());

            while (!temp.isEmpty()) bw.write(temp.pop());
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}

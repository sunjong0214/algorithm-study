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
    String rule = br.readLine();
    String[] rules;
    rules = rule.split("\\*| ");

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      if (str.length() < rules[0].length() + rules[1].length()) {
        bw.write("NE\n");
        continue;
      }
      String front = str.substring(0, rules[0].length());
      String back = str.substring(str.length() - rules[1].length(), str.length());
      if (front.equals(rules[0]) && back.equals(rules[1])) {
        bw.write("DA\n");
      } else {
        bw.write("NE\n");
      }
    }
    br.close();
    bw.close();
  }
}
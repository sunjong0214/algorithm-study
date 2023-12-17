import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int count = 1;
    int num = 666;
    while (n != count) {
      num++;
      if(String.valueOf(num).contains("666")) {
        count++;
      }
    }
    System.out.println(num);

    br.close();
    bw.flush();
    bw.close();
  }
}

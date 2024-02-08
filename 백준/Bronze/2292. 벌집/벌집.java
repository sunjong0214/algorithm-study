import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int x = Integer.parseInt(br.readLine());

    int power = 1;
    int temp = 1;
    while (temp < x) {
      temp += 6 * power++;
    }
    System.out.println(power);
    br.close();
  }
}

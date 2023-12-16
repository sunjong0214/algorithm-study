import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1259 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while (true) {
      String str = br.readLine();
      if (str.equals("0")) {
        break;
      }
      if (str.length() == 1)
        System.out.println("yes");
      for (int i = 0; i<str.length()/2; ) {
        if(str.charAt(i) == str.charAt(str.length()-i-1)) {
          i++;
          if (i >= str.length()/2) {
            System.out.println("yes");
            break;
          }
          continue;
        } else {
          System.out.println("no");
          break;
        }
      }
    }
   }
  } 

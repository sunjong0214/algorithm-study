import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1018 {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());
    String[][] str = new String[x][y];
    
    for(int i=0; i<x; i++){
      String chess = br.readLine();
      for(int j=0; j<y; j++)
        str[i][j] = chess.charAt(j);
    }
//w, b 의 갯수는 32개씩
    
    
  }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1018 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());
    char[][] str = new char[x][y];
    int i;
    int j;
    for(i=0; i<x; i++){
      String chess = br.readLine();
      for(j=0; j<y; j++)
        str[i][j] = chess.charAt(j);
    }
    i = 0;
    j = 0;
    //하나하나 다 체크한다. 조건문은 i, j + 7 값이 x,y값을 넘어가면 contiune
    boolean B_check =  str[i][j] == 'B';
    boolean W_check = str[i][j] == 'w';
    while(i+7<=x-1 && j+7<=y-1){
      int check = 0;
      if( B_check || W_check ){
        if(B_check)
          check = 1;
        else if(W_check)
          check = 2;
        j++;
      }
      if(check == 1){
        if(W_check)
          continue;
      }
    }
  }
}

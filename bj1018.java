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
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    char[][] str = new char[x][y];
    int i;
    int j;
    for (i=0; i<x; i++) {
      String chess = br.readLine();
      for (j=0; j<y; j++)
        str[i][j] = chess.charAt(j);
    }
    int chess_i = 0;
    int chess_j = 0;
    //하나하나 다 체크한다. 조건문은 i, j + 7 값이 x,y값을 넘어가면 contiune
    //boolean 조건은 선언하고 거쳐가면서 false에서 true로 바뀜
    for(chess_i=0; chess_i<8; chess_i++){
      boolean B_check =  str[i][j] == 'B';
      boolean W_check = str[i][j] == 'W'; //여기서 이미 시작 알파벳이 무엇인지 처리가능 true
      for(chess_j=0; chess_j<8; chess_j++){
        if(B_check == true){
          
        }
      }
    }
    //true = w 로 시작 false = b로 시작
    
    //str 배열을 체스판 형식으로 검사하고 칠해야하는 수를 구하는 함수
    //위 함수를 나올 수 있는 경우의 수 모두 검사하고 그 중 최소값을 찾아내기
    bw.write(min+"\n");
    br.close();
    bw.flush();
    bw.close();
      //x-7,y-7 을 이용해 경우의 수 구해서 배열 선언, 각 경우마다 최소값 구한 후 저장, 최소값 중 제일 작은 값 출력
  }
}
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
    int i = 0;
    int j = 0;
    for (i=0; i<x; i++) {
      String chess = br.readLine();
      for (j=0; j<y; j++)
        str[i][j] = chess.charAt(j);
    }
    int[] minArr = new int[((i-7)*(j-7))];
    int min = 0;
    int iMax = i;
    int jMax = j;
    i = 0; //기본인덱스
    j = 0;
    int minIndex = 0;
    while(true){
      if(i+7>iMax){
        break;
      } else if (j+7>jMax){
          j = 0;
          i++;
          continue;
      }
      
      int chess_i = 0; //체스판 인덱스
      int chess_j = 0;
      int check = 0; // 다음이 B = 1, W =2
      //하나하나 다 체크한다. 조건문은 i, j + 7 값이 x,y값을 넘어가면 contiune
      //boolean 조건은 선언하고 거쳐가면서 false에서 true로 바뀜
      boolean B_check = false;
      boolean W_check = false;
      for(chess_i=i; chess_i<i+7; ){
        chess_j = 0;
        if (B_check == true){
          W_check = true;
          B_check = false;
        } else if(W_check == true){
          W_check = false;
          B_check = true;
        } else {
          B_check = str[chess_i][j] == 'B';
          W_check = str[chess_i][j] == 'W'; //여기서 이미 시작 알파벳이 무엇인지 처리가능 true
        }
        if(B_check == true){
            check = 2;
          for(chess_j=j; chess_j<j+8; chess_j++){
            if(str[chess_i][chess_j] == 'W' && check == 1){
              check = 2;
              continue;
            }
            else if(str[chess_i][chess_j] == 'B' && check == 2){
              check = 1;
              continue;
            }
            min++;
            if (str[chess_i][chess_j] == 'W')
              check = 1;
            else
              check = 2;
            }
          } else if(W_check == true){
            check = 1;
          for(chess_j=j; chess_j<j+8; chess_j++){
            if(str[chess_i][chess_j] == 'W' && check == 1){
              check = 2;
              continue;
            }
            else if(str[chess_i][chess_j] == 'B' && check == 2){
              check = 1;
              continue;
            }
            min++;
            if (str[chess_i][chess_j] == 'W')
              check = 1;
            else
              check = 2;
            }
          }
          chess_i++;
        }
        if (minIndex < (iMax-7)*(jMax-7))
        {
          minArr[minIndex] = min;
          minIndex++;
        }
        min = 0;
        j++;
      }
    int result = 0;
    int sum = minArr[0];
    //true = w 로 시작 false = b로 시작
    for (i=0; i<minArr.length; i++) {
      if (i<minArr.length){
        if(sum < minArr[i]){
          sum = minArr[i];
        }
      }
    }
    //str 배열을 체스판 형식으로 검사하고 칠해야하는 수를 구하는 함수
    //위 함수를 나올 수 있는 경우의 수 모두 검사하고 그 중 최소값을 찾아내기
    bw.write(sum+"\n");
    br.close();
    bw.flush();
    bw.close();
      //x-7,y-7 을 이용해 경우의 수 구해서 배열 선언, 각 경우마다 최소값 구한 후 저장, 최소값 중 제일 작은 값 출력
  }
}
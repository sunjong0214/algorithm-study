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
    i = 0;
    j = 0;
    //하나하나 다 체크한다. 조건문은 i, j + 7 값이 x,y값을 넘어가면 contiune
    //boolean 조건은 선언하고 거쳐가면서 false에서 true로 바뀜
    boolean B_check =  str[i][j] == 'B';
    boolean W_check = str[i][j] == 'W'; 
    //여기서 이미 시작 알파벳이 무엇인지 처리가능 true
    //true = w 로 시작 false = b로 시작
    int index_x = 0;
    int index_y = 0;
    int check = 0;
    int min = 0;
    int min_check = 0;
    int[] arr = new int[(x-7)*(y-7)];//경우의 수 계산 및 그 크기의 배열 선언 min 값이 들어감
    while (i+7<=x-1 && j+7<=y-1) { // 조건 다시 설정
      if ( j>index_y+7 ) {  
        j = index_y;
        i++;
      }
      if ( i>index_x+7 ) {
        i = index_x;
        arr[min_check] = min;
        min_check++;
      }
      if ( check == 0 ) { //첫 시작이 B, W인지 확인
        index_x = i;
        index_y = j;
        if ( B_check )
          check = 1;
        else if ( W_check )
          check = 2;
        j++;
      }
      if ( check == 1 ) { // B -> W 가 맞는지 확인, 맞다면 다음 인덱스로 아니라면 min++ 후 다음 인덱스
        if ( W_check ) {
          j++;
          check = 2;
        }
        else if ( B_check ) {
          check = 2;
          j++;
          min++;
        }
        continue;
      }else if ( check == 2 ) {
        if ( B_check ) {
          j++;
          check = 1;
        }
        else if ( W_check ) {
          check = 1;
          j++;
          min++;
        }
        continue;
      }
    }
    i = 0;
    min = arr[0];
    while(arr[i] <= min_check){
      if(arr[i] > arr[i+1])
        min = arr[i+1];
      i++;
    }
    bw.write(min+"\n");
    br.close();
    bw.flush();
    bw.close();
      //x-7,y-7 을 이용해 경우의 수 구해서 배열 선언, 각 경우마다 최소값 구한 후 저장, 최소값 중 제일 작은 값 출력
  }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2577 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] arr = new int[10];
    int sum = 1;
    for(int i=0; i<3; i++){
      sum *= Integer.parseInt(br.readLine());
    }
    while(sum>0){
      arr[sum%10]++;
      sum = sum/10;
    }
    for(int j=0; j<10; j++){
      bw.write(arr[j]+"\n");
    }
    //bw.write(sum + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}

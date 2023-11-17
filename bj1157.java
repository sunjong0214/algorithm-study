import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        String str = br.readLine();
        br.close();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) < 95){
                arr[str.charAt(i)-65]++;
            }else{
                arr[str.charAt(i)-97]++;
            }
        }
        //최대값 저장할 변수, 인덱스 위치 저장할 변수
        int max = 0;
        int index = 0;
        for(int j=0; j<arr.length; j++){
            if(max<=arr[j]){
                max = arr[j];
                index = j;
            }
        }
        for(int k=0; k<arr.length; k++){
            if(arr[k] == max){
                if(k == index){
                    continue;
                }
                bw.write("?");
                bw.flush();
                System.exit(0);
            }
        }
        bw.write((char)(index + 65) + "\n"); //아스키코드에서 문자로 변환하는 방법은 (char)사용
        bw.flush();
        bw.close();
    }
}

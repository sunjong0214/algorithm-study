import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class bj1654 {
   public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] num = new int[n];
    for(int i=0; i<n; i++) {
      num[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(num);
    long max = num[n-1]; // 전선 최소값인 동시에 이분 탐색을 위한 인덱스 길이
    //int[] arr = new arr[max];
    long min = 1; // 인덱스 최소값
    int count = 0; // k와 비교할 값
    long index = 0;
    long maxcount = 0;
    int check = 0;
    while (true) {
      index = ((max-min)/2)+min; // 탐색에 들어갈 중간 인덱스
      if (max == num[0]) {
        index += 1;
      }
      count = 0;
      for (int i=0; i<n; i++) { // 전선 몇개 하는지
        count += num[i]/index;
      }
      if (check == 1 && index == maxcount) {
        break;
      } else if (count >= k && check == 1) {
        maxcount = index;
        min = index;
      }else if (count < k && check == 1) {
        max = index;
      }
      if (count >= k && check == 0) {
        min = index;
        maxcount = index; //현재 자리를 저장 현재 시점에선 가장 큼
        check = 1;
      }else if (count < k && check == 0) {
        max = index;
      }
    }
    bw.write(maxcount + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}

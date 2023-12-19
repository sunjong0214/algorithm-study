import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] num = new int[n];
    int sum = 0;
    for(int i=0; i<n; i++) {
      num[i] = Integer.parseInt(br.readLine());
    }
    // Arrays.sort(num, new Comparator<Integer>() {
    //   @Override
    //   public int compare(Integer o1, Integer o2) {
    //     return o1-o2;
    //   }
    // });
    Arrays.sort(num);
    int max = num[0]; // 전선 최소값인 동시에 이분 탐색을 위한 인덱스 길이
    int[] arr = new arr[max];
    int min = 0; // 인덱스 최소값
    int count = 0; // k와 비교할 값
    int index = 0;
    while (true) {
      index = (max-min)/2; // 탐색에 들어갈 중간 인덱스
      for (int i=0; i<n; i++) {
        count = num[i]/index;
      }
      if (count > k) { // 필요한 전선 갯수보다 더 많은 전선을 만들었을 때 = 전선의 길이가 원하는 값보다 작다.
        min = index;
      } else if (count < k) { // 필요한 전선 갯수보다 더 적은 전선을 만들었을 때 = 전선의 길이가 원하는 값보다 크다.
        max = index;
      } else {
        break;
      }
    }
    bw.write(index + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}

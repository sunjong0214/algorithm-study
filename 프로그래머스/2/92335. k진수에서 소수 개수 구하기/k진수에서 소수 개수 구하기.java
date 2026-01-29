import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // 진수 변경 -> 소수 판별 -> 찾은 소수 조건 탐색
        int num = n;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        StringBuilder rSb = sb.reverse();

        int start = 0;
        int end = 0;
        
        // 0을 기준으로 split
        String[] sArr = String.valueOf(rSb).split("0");

        // long max = 0L;
        for (String s : sArr) {
            if (!s.isBlank()) {
                // max = Math.max(max, Long.parseLong(s));
                long longNum = Long.parseLong(s);
                boolean isPrime = true;
                if (longNum == 2) answer++;
                if (longNum % 2 == 0) continue;
                if (longNum == 1L) continue;
                for (long i = 3; i * i <= longNum; i += 2) {
                    if (longNum % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) answer++;
            }
        }
        
        // boolean[] prime = new boolean[max + 1];
        
        // prime[1] = true;
        // for (int i = 2; i < max; i++) {
            // for (int j = i * 2; j < max; j *= 2) {
                // prime[j] = true;
            // }
        // }
        
//         for (String s : sArr) {
//             if (!s.isBlank() && !prime[Integer.parseInt(s)]) {
//                 answer++;
//             }
        // }
        
        return answer;
    }
}
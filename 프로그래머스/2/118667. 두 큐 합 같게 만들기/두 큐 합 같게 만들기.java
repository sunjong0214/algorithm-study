import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum += queue1[i];
            sum += queue2[i];
            q1Sum += queue1[i];
            q2Sum += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        if (sum % 2 == 1) {
            answer = -1;
        } else {
            int idx = 0;
            answer = 0;
            while (!q1.isEmpty() && !q2.isEmpty()) {
                idx++;
                if (idx > queue1.length + queue2.length * 2) return -1;
                long qDiff = q1Sum - q2Sum;
                if (q1.peek() > sum / 2 || q2.peek() > sum / 2) {
                    answer = -1;
                    break;
                }
                if (qDiff > 0) {
                    answer++;
                    q2Sum += q1.peek();
                    q1Sum -= q1.peek();
                    q2.offer(q1.poll());
                } else if (qDiff < 0) {
                    answer++;
                    q2Sum -= q2.peek();
                    q1Sum += q2.peek();
                    q1.offer(q2.poll());
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}
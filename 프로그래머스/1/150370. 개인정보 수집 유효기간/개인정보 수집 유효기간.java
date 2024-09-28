import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] split = today.split("\\.");
        int tY = Integer.parseInt(split[0]);
        int tM = Integer.parseInt(split[1]);
        int tD = Integer.parseInt(split[2]);

        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            termMap.put(s[0], Integer.parseInt(s[1]));
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] pri = privacies[i].split(" ");
            String[] priDate = pri[0].split("\\.");
            int pY = Integer.parseInt(priDate[0]);
            int pM = Integer.parseInt(priDate[1]);
            int pD = Integer.parseInt(priDate[2]);

            int termsM = termMap.get(pri[1]);

            if (pM + termsM > 12) {
                pY += (pM + termsM) / 12;
                pM = (pM + termsM) % 12;
                if (pM == 0) {
                    pY--;
                    pM = 12;
                }
            } else {
                pM += termsM;
            }
            if (tY > pY) {
                result.add(i + 1);
            } else if (tY == pY && tM > pM) {
                result.add(i + 1);
            } else if (tY == pY && tM == pM && tD >= pD) {
                result.add(i + 1);
            }
        }
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
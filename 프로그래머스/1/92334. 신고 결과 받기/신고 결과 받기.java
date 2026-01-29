import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 -> 1번에 한번, 중복 X
        // k번 이상 시 정지 -> 정지 시 신고한 유저들에게 메일 발송 -> 신고한 내용 마지막에 한번에 정지, 발송 같이
        // map에 담고, 누가 신고했는지 set으로 추가, set의 길이로 k 확인
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> cntMap = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for (String id : id_list) {
            map.put(id, new HashSet<>());
            cntMap.put(id, 0);
        }
        StringTokenizer st;
        for (String str : report) {
            st = new StringTokenizer(str);
            String to = st.nextToken();
            String from = st.nextToken();
            
            Set<String> fromSet = map.get(from);
            fromSet.add(to);
        }

        for (Set<String> set : map.values()) {
            if (set.size() >= k) {        
                for (String el : set) {
                    cntMap.put(el, cntMap.get(el) + 1);
                }
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = cntMap.get(id_list[i]);
        }
        return answer;
    }
}
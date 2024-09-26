import java.util.*;
import java.io.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 행렬 만들어서 i = 준 사람, j = 받은 사람 해서 ++
        // 비교할 땐 {1,0} , {0,1} 비교
        // 더 작은 수의 i가 받을 사람
        // 결과를 저장할 배열에 ++
        // 선물 지수를 저장할 배열도 하나 만들어서 줬을 때 ++, 받을 때 --해서 비교
        int size = friends.length;
        String[][] arr = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = friends[j];
            }
        }

        int[][] sendCnt = new int[size][size];
        int[] giftCnt = new int[size];
        int gSize = gifts.length;
        for (int i = 0; i < gSize; i++) {
            String[] list = gifts[i].split(" ");
            String to = list[0];
            String from = list[1];
            for (int j = 0; j < size; j++) {
                if (arr[j][j].equals(to)) {
                    for (int k = 0; k < size; k++) {
                        if (arr[j][k].equals(from)) {
                            giftCnt[j]++;
                            giftCnt[k]--;
                            sendCnt[j][k]++;
                        }
                    }
                }
            }
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i == j) {
                    continue;
                }
                if (sendCnt[i][j] > sendCnt[j][i]) {
                    result[i]++;
                } else if (sendCnt[i][j] < sendCnt[j][i]) {
                    result[j]++;
                } else {
                    if (giftCnt[i] > giftCnt[j]) {
                        result[i]++;
                    } else if (giftCnt[j] > giftCnt[i]) {
                        result[j]++;
                    }
                }
            }
        }
        for (int i : result) {
            if (i > answer) {
                answer = i;
            }
        }
        return answer;
    }
}
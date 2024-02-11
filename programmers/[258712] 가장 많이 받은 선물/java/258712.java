import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] giftGraphList = new int[friends.length][friends.length];
        int[][] resultList = new int[friends.length][4];
        HashMap<String, Integer> friendMap = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }

        for (String temp : gifts) {
            String[] ab = temp.split(" ");
            giftGraphList[friendMap.get(ab[0])][friendMap.get(ab[1])]++;
        }

        for (Map.Entry<String, Integer> entry : friendMap.entrySet()) {
            int idx = entry.getValue();
            int givenCnt = 0;
            int receivedCnt = 0;

            for (int i = 0; i < friends.length; i++) {
                givenCnt += giftGraphList[idx][i];
                receivedCnt += giftGraphList[i][idx];
            }

            resultList[idx][0] = givenCnt;
            resultList[idx][1] = receivedCnt;
            resultList[idx][2] = givenCnt - receivedCnt;
        }

        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (giftGraphList[i][j] == giftGraphList[j][i]) {
                    if (resultList[i][2] > resultList[j][2]) resultList[i][3]++;
                    else if (resultList[i][2] < resultList[j][2]) resultList[j][3]++;
                } else if (giftGraphList[i][j] > giftGraphList[j][i]) resultList[i][3]++;
                else resultList[j][3]++;
            }
        }

        for (int i = 0; i < friends.length; i++) {
            answer = Math.max(answer, resultList[i][3]);
        }

        return answer;
    }
}
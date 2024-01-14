import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> list = new ArrayList<>();

        for (String term : terms) {
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] date = privacy.split(" ")[0].split("\\.");

            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            int checkTerm = map.get(privacy.split(" ")[1]);

            StringBuffer sb = new StringBuffer();

            year = year + (month + checkTerm - 1) / 12;
            month = (month + checkTerm - 1) % 12 + 1;

            sb.append(String.valueOf(year));
            if (month < 10) {
                sb.append(String.format("%02d", month));
            } else {
                sb.append(String.valueOf(month));
            }
            if (day < 10) {
                sb.append(String.format("%02d", day));
            } else {
                sb.append(String.valueOf(day));
            }

            int todayNum = Integer.parseInt(today.replace(".", "")); 
            int compare = Integer.parseInt(String.valueOf(sb));

            if (todayNum >= compare) {
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
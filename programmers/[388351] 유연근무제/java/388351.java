class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int[] reSchedules = new int[schedules.length];
        for (int i = 0; i < schedules.length; i++) {
            int tmpSchedule = schedules[i];
            int hour = tmpSchedule / 100;
            int minute = tmpSchedule % 100 + 10;
            if (minute >= 60) {
                hour += 1;
                minute -= 60;
            }
            tmpSchedule = hour * 100 + minute;
            
            boolean isPass = true;
            
            for (int j = 0; j < 7; j++) {
                int tmpStartDay = (startday + j - 1 )% 7 + 1;
                if (tmpStartDay == 6 || tmpStartDay == 7)
                    continue;
                if (tmpSchedule < timelogs[i][j]) {
                    isPass = false;
                }
            }
            if (isPass) {
                answer++;
            }
        }
        
        return answer;
    }
}
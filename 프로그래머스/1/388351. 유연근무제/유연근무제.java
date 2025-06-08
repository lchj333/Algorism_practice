import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        
        for(int s = 0; s < schedules.length; s++) {
            int safeTime = getPlusTime(schedules[s], 10);
            int day = startday;
            
            // 해당 인원의 타임로그
            for(int timelog : timelogs[s]) {
                if(5 >= day && safeTime < timelog) {
                    // 이벤트 실패!
                    answer--;
                    break;
                }
                // 날짜 증가
                day = day % 7 + 1;
            }
        }
        
        return answer;
    }
    
    public int getPlusTime(int time, int add) {
        int minute = time % 100 + add;
        int hour = time / 100 + minute / 60;
        minute %= 60;
        return hour * 100 + minute;
    }
}

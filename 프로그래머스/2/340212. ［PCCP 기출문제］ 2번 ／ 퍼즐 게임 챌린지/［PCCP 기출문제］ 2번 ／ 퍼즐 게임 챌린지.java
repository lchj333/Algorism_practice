import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        boolean plusThousand = true;
        int level = 1;
        while(level <= 100001) {
            // 총 소요시간 계산
            long totalTime = calcPlayTime(level, diffs, times);
            
            // 증감 선택 체크
            if(plusThousand) {
                if(totalTime > limit) {
                    // 레벨이 적정치 미만임.
                    level += 1000;
                }else {
                    // 레벨이 적정치를 조과했을 수 있음. (정답 범위 : level-999 ~ level)
                    plusThousand = false;
                    if(level > 1) {
                        level -= 999;
                    }else {
                        // level값 1이 정답인 케이스
                        answer = level;
                        break;
                    }
                }
            }else {
                if(totalTime > limit) {
                    // 레벨이 적정치 미만임.
                    level ++;
                }else {
                    answer = level;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public long calcPlayTime(long level, int[] diffs, int[] times) {
        long totalTime = 0;
        
        for(int idx = 0; idx < times.length; idx++) {
            // 풀이 시간 계산
            long prevTime = idx > 0 ? times[idx-1] : 0;
            totalTime += playPuzzle(level, diffs[idx], times[idx], prevTime);
        }
        
        return totalTime;
    }
    
    public long playPuzzle(long level, long diff, long nowTime, long prevTime) {
        if(level < diff) {
            return (nowTime + prevTime) * (diff - level) + nowTime;
        }else {
            return nowTime;
        }
    }
}
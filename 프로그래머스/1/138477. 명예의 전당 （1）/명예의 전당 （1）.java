import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int answerIdx = 0;
        
        int maxArraySize = 0;
        int[] rankArray = new int[k];
        
        for(int s : score) {
            if(maxArraySize < k) {
                maxArraySize++;
            }
            
            int newRank = s;
            for(int i = 0; i < maxArraySize; i++) {
                if(newRank > rankArray[i]) {
                    int tempRank = rankArray[i];
                    rankArray[i] = newRank;
                    newRank = tempRank;
                }
            }
            
            answer[answerIdx++] = rankArray[maxArraySize - 1];
        }
        
        return answer;
    }
}
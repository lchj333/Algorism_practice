import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        for(int x = score.length - m; x > -1; x -= m) {
            answer += score[x] * m;
        }
        
        return answer;
    }
}


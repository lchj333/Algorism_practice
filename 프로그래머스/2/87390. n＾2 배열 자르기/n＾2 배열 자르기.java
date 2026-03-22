import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int answerIdx = 0;
        // 시작점 2차원 좌표
        int leftY = (int) (left / n);
        int leftX = (int) (left % n);
        // 종료점 2차원 좌표
        int rightY = (int) (right / n);
        int rightX = (int) (right % n);
        
        for(int y = leftY; y <= rightY; y++) {
            
            // 열 인덱스 최소, 최대 계산
            int x = y == leftY ? x = leftX : 0;
            int maxX = y == rightY ? rightX : n - 1;
            
            for(; x <= maxX; x++) {
                
                answer[answerIdx] = (x <= y ? y : x ) + 1;
                // System.out.printf("%d [y=%d, x=%d] = %d%n", left + answerIdx, y, x, value);
                answerIdx++;
            }
            
        } 
        
        return answer;
    }
}
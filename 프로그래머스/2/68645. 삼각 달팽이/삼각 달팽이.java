// https://school.programmers.co.kr/questions/52719 를 참고 했음.
// 2차 평면 배열로 변환한다.
// 진행방향에 대한 방향벡터를 이용해서 피라미드 구조를 완성시킨다.
// 결과물을 1차원 배열로 변환하여 반환한다.
import java.util.*;
class Solution {
    
    final int[] vecY = new int[] {1, 0, -1};
    final int[] vecX = new int[] {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] pyramid = new int[n][n];
        
        // 최대값
        int number = 1;
        int maxNumber = ((n + 1) * n / 2);
        
        // 달팽이 방향 숫자 채우기
        int vecIdx = 0;
        int y = 0;
        int x = 0;
        pyramid[y][x] = number++;
        while(number <= maxNumber) {
            int tempY = y + vecY[vecIdx];
            int tempX = x + vecX[vecIdx];
            
            if(checkRange(pyramid.length, tempY, tempX) && pyramid[tempY][tempX] == 0) {
                pyramid[tempY][tempX] = number++;
                y = tempY;
                x = tempX;
            }else {
                // 다른 방향 한번 더
                vecIdx = (vecIdx + 1) % vecY.length;
                tempY = y + vecY[vecIdx];
                tempX = x + vecX[vecIdx];
                if(checkRange(pyramid.length, tempY, tempX) && pyramid[tempY][tempX] == 0) {
                    pyramid[tempY][tempX] = number++;
                    y = tempY;
                    x = tempX;
                }else {
                    // 모두 꽉참
                    break;
                }
            }
        }
        
        // 1차원 배열 변환
        int i = 0;
        int[] answer = new int[maxNumber];
        for(y = 0; y < n; y++) {
            for(x = 0; x <= y; x++) {
                answer[i++] = pyramid[y][x];
            }
        }
        
        return answer;
    }
    
    public boolean checkRange(int length, int y, int x) {
        return length > y && y > -1 && length > x && x > -1;
    }
}
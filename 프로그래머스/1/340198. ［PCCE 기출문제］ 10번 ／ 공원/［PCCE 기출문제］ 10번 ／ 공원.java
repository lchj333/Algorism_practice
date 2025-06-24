import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int matIdx = 0;
        Arrays.sort(mats);
        
        for(int parkY = 0; parkY < park.length; parkY++) {
            for(int parkX = 0; parkX < park[parkY].length; parkX++) {
                // 작은사이즈 -> 큰사이즈 순으로 돗자리 범위 찾기
                while(matIdx < mats.length && canIRestHere(park, parkY, parkX, mats[matIdx])) {
                    // 돗자리 찾았을때 다음사이즈 탐색
                    answer = mats[matIdx];
                    matIdx++;
                }
            }
        }
        
        return answer;
    }
    
    // 돗자리 범위 구하기
    public boolean canIRestHere(String[][] park, int y, int x, int matSize) {
            
        for(int addY = 0; addY < matSize; addY++) {
            int chkY = y + addY;
            
            if(chkY >= park.length) {  
                return false;
            }
                
            for(int addX = 0; addX < matSize; addX++) {
                int chkX = x + addX;
                    
                // 빈공간?
                if( ! (chkX < park[chkY].length && "-1".equals(park[chkY][chkX]))) {
                    return false;
                }
            }
        }
        // 돗자리 가능!
        return true;
    }
}

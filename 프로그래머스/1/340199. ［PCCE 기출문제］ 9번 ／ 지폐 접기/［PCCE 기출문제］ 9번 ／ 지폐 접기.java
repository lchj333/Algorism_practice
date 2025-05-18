import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(true) {
            int billIdx;
            
            // 가장 큰 지폐 길이 체크
            if(bill[0] - bill[1] >= 0) {
                billIdx = 0;
            }else {
                billIdx = 1;
            }
            
            // 사이즈 확인
            if(bill[billIdx] <= wallet[0] && bill[1 - billIdx] <= wallet[1]) {
                return answer;
            }
            if(bill[billIdx] <= wallet[1] && bill[1 - billIdx] <= wallet[0]) {
                return answer;
            }
            
            // 접기
            bill[billIdx] /= 2;
            answer++;
        }
    }
}
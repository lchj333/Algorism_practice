import java.util.*;
// 슬라이드 윈도우 알고리즘
class Solution {
    static final int DISCOUNT_DAYS = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 장보기 목록 세팅
        int totalWantNumber = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
            totalWantNumber += number[i];
        }
        
        int haveWantNumber = 0;
        int i = 0;
        while(i < discount.length + totalWantNumber - DISCOUNT_DAYS) {
            if(i >= DISCOUNT_DAYS) { // 현재 10개 이상 탐색 구간
                // 아이템 반환
                Integer oldOneNumber = wantMap.get(discount[i - 10]);
                if(oldOneNumber != null) {
                    wantMap.put(discount[i - 10], ++oldOneNumber);
                    haveWantNumber--;
                }
                // 아이템 가져가기
                Integer newOneNumber = wantMap.get(discount[i]);
                if(newOneNumber != null) {
                    wantMap.put(discount[i], --newOneNumber);
                    haveWantNumber++;
                }
            }else { // 현재 10개 미만 탐색 시
                Integer wantNumber = wantMap.get(discount[i]);
                if(wantNumber != null) {
                    wantMap.put(discount[i], --wantNumber);
                    haveWantNumber++;
                }
            }
            
            // 정답 체크
            // System.out.printf("%s%n", wantMap);
            if(haveWantNumber >= totalWantNumber && checkWantList(wantMap, want)) {
                answer++;
            }
            
            // 증감
            i++;
        }
        
        return answer;
    }
    
    public boolean checkWantList(Map<String, Integer> wantMap, String[] want) {
        for(String w : want) {
            if(wantMap.get(w) > 0) {
                return false;
            }
        }
        return true;
    }
}
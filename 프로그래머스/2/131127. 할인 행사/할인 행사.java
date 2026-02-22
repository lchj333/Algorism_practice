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
                // 오래된 아이템 반환
                if(wantMap.containsKey(discount[i - 10])) {
                    wantMap.put(discount[i - 10], wantMap.get(discount[i - 10]) + 1);
                    haveWantNumber--;
                }
                // 새 아이템 가져가기
                if(wantMap.containsKey(discount[i])) {
                    wantMap.put(discount[i], wantMap.get(discount[i]) - 1);
                    haveWantNumber++;
                }
            }else { // 현재 10개 미만 탐색 시 일단 가져가기
                if(wantMap.containsKey(discount[i])) {
                    wantMap.put(discount[i], wantMap.get(discount[i]) - 1);
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
import java.util.*;

class Solution {
    private final List<Set<Integer>> groupList = new ArrayList<>();
    
    public int solution(int[] cards) {
        int answer = 0;
        
        // 상자 탐색
        for(int card : cards) {
            if(isDuplicatedCard(card)) continue;
                
            Set<Integer> group = new HashSet<>();
            group.add(card);
            groupList.add(group);

            openNextBox(group, cards, card - 1);
        }
        
        // 결과 도출
        int[] bestBoxGroups = new int[2];
        for(Set<Integer> group : groupList) {
            int size = group.size();
            
            for(int i = 0; i < bestBoxGroups.length; i++) {
                if(size > bestBoxGroups[i]) {
                    // 현재 사이즈로 값을 변경 후 기존 값은 다음 반복문에서 다시 비교.
                    int temp = bestBoxGroups[i];
                    bestBoxGroups[i] = size;
                    size = temp;
                }
            }
        }
        
        return bestBoxGroups[0] * bestBoxGroups[1];
    }
    
    // 상자 오픈
    public void openNextBox(Set<Integer> group, int[] cards, int boxIndex) {
        // 카드 get
        int card = cards[boxIndex];
        
        // 중복 카드 체크
        if(isDuplicatedCard(cards[boxIndex])) return;
        
        // 그룹 추가
        group.add(card);
        
        // 다음 상자 오픈
        openNextBox(group, cards, card - 1);
    }
    
    /** 카드 중복 오픈 체크
        true : 중복, flase : 신규
    */
    public boolean isDuplicatedCard(int card) {
        for(Set<Integer> group : groupList) {
            if(group.contains(card)) {
                return true;    
            }
        }
        return false;
    }
}
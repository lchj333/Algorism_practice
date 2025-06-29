import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Map<String, Integer>> sendMap = new HashMap<>();
        Map<String, Integer> sendCntMap = new HashMap<>();
        Map<String, Integer> receiveCntMap = new HashMap<>();
        
        // 주고 받은 선물은?
        for(String gift : gifts) {
            String[] g = gift.split(" ");
            
            sendMap = refreshForGiftCount(sendMap, g[0], g[1], 1);
            
            sendCntMap.put(g[0], sendCntMap.getOrDefault(g[0], 0) + 1);
            receiveCntMap.put(g[1], receiveCntMap.getOrDefault(g[1], 0) + 1);
        }
        
        
        for(String me : friends) {
            int nextMonthGifts = 0;
            // 내 선물 지수
            int myGiftPoint = sendCntMap.getOrDefault(me, 0) - receiveCntMap.getOrDefault(me, 0);
            
            Map<String, Integer> sendInfo = sendMap.get(me);
            
            for(String you : friends) {
                if(me.equals(you)) {
                    continue;
                }
                
                // 내가 너에게 준 선물 개수
                int forYou = sendInfo != null ? sendInfo.getOrDefault(you, 0) : 0;
                
                // 너가 나에게 준 선물 개수
                int toMe = sendMap.get(you) != null ? sendMap.get(you).getOrDefault(me, 0) : 0;
                
                
                // 다음달 받을 선물 계산
                if(forYou == toMe) {
                    // 동등 교환 일 때
                    // 너의 선물 지수
                    int YourGiftPoint = sendCntMap.getOrDefault(you, 0) - receiveCntMap.getOrDefault(you, 0);
                    // 선물지수 비교
                    if(myGiftPoint > YourGiftPoint) {
                        nextMonthGifts++;
                    }

                }else if(forYou > toMe) {
                    // 내가 더 많이 줌
                    nextMonthGifts++;
                }
            }
            
            // 가장 많은 선물을 받을 사람은?
            answer = Math.max(answer, nextMonthGifts);
        }
        
        return answer;
    }
    
    // Map에 선뭃 현황 갱신
    public Map<String, Map<String, Integer>> refreshForGiftCount(Map<String, Map<String, Integer>> giftMap, String from,  String to, int count) {
        Map<String, Integer> countMap = giftMap.getOrDefault(from, new HashMap<>());
        countMap.put(to, countMap.getOrDefault(to, 0) + count);
        giftMap.put(from, countMap);
        return giftMap;
    }
}



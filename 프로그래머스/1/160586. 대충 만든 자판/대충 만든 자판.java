import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // 목표 알파벳 도달에 필요한 최소 푸쉬회수 정보를 해시맵으로 저장
        Map<String, Integer> kMap = new HashMap<>();
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                String kStr = key.substring(i, i+1);
                Integer kCnt = kMap.get(kStr);
                if(kCnt == null) {
                    kMap.put(kStr, i+1);
                }else {
                    kMap.put(kStr, Math.min(i+1, kCnt));
                }
            }
        }
        
        // System.out.println("kMap => " + kMap);
        
        for(int idx = 0; idx < targets.length; idx++) {
            int total = 0;
            
            for(int i = 0; i < targets[idx].length(); i++) {
                String target = targets[idx].substring(i, i+1);
                Integer cnt = kMap.get(target);
                
                if(cnt != null) {
                    total += cnt;
                }else {
                    // 목표 도달 불가
                    total = -1;
                    break;
                }
            }
            
            answer[idx] = total;
        }
        
        return answer;
    }
}
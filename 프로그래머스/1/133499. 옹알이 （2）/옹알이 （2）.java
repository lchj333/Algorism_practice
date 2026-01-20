import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        Set<String> wordSet = new HashSet<>(Arrays.asList("aya", "ye", "woo", "ma"));
        
        for(String babySaid : babbling) {
            
            int startIdx = 0;
            String prevWord = "";
                
            for(int lastIdx = 1; lastIdx <= babySaid.length(); lastIdx++) {
                String word = babySaid.substring(startIdx, lastIdx);

                if(wordSet.contains(word)) {
                    
                    // 연속해서 같은 발음 불가능
                    if(word.equals(prevWord)) break;
                    
                    prevWord = word;
                    startIdx = lastIdx; // 다음 단어 탐색을 위해 인덱스 이동
                }
            }
            
            // 인덱스 이동 된 값이 전제 길이와 같다면 모두 발음된 것
            if(startIdx == babySaid.length()) answer++;
        }
        
        return answer;
    }
}
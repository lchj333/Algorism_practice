import java.util.*;

class Solution {
    final static String[] EN_NUMBER_ARRAY = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        StringBuilder answerBuilder = new StringBuilder();
        
        Map<String, Integer> englishMap = new HashMap<>();
        for(int i = 0; i < EN_NUMBER_ARRAY.length; i++) {
            englishMap.put(EN_NUMBER_ARRAY[i], i);
        }
        
        int startIdx = -1;
        for(int i = 0; i < s.length(); i++) {
            int result = -1;
            
            if(startIdx > -1) {
                result = englishMap.getOrDefault(s.substring(startIdx, i+1), -1);
            }else {
                try {
                    result = Integer.parseInt(s.substring(i, i+1));
                }catch(Exception e) {
                    startIdx = i;
                }
            }
            
            if(result > -1) {
                answerBuilder.append(result);
                startIdx = -1;
            }
        }
        
        return Integer.parseInt(answerBuilder.toString());
    }
}
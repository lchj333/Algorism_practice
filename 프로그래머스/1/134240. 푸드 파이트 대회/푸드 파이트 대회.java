import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder resultFood = new StringBuilder();
        
        // 왼쪽 음식 리스트 작성
        for(int item = 1; item < food.length; item++) {
            int maxItemCnt = food[item] / 2;
            
            for(int itemCnt = 1; itemCnt <= maxItemCnt; itemCnt++) {
                resultFood.append(item);
            }
        }
        
        // 뒤집은 String 생성
        StringBuilder reverseFood = new StringBuilder(resultFood).reverse();
        
        // 물 추가 + 합치기
        resultFood.append(0).append(reverseFood);
        
        return resultFood.toString();
    }
}
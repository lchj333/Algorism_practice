import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int answerIdx = 0;
        
        // 오름차순 나열
        List<Integer> numList = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            numList.add(i);
        }
        
        // 전체 경우의 수 (팩토리얼)
        long numOfCases = calcFactory(n, n - 1);
        // 전체 경우의 수 등분하기
        long piece = numOfCases / numList.size();
        
        long left = 0;
        long right = piece;
        int removeIdx = 0;
        
        while(numList.size() > 1 && right <= numOfCases) {
            
            if(left < k && k <= right) {
                // 등분 값 안에 k가 있으면 정답 넣기
                answer[answerIdx++] = numList.remove(removeIdx);
                removeIdx = 0;
                // 더 작은 조각으로 등분
                piece /= numList.size();
                right = left + piece;
            }else {
                // 아니면 등분만큼 증가 후 다시 체크
                removeIdx++;
                left += piece;
                right += piece;
            }
        }
        // 단, 하나!
        answer[answerIdx++] = numList.get(0);
        
        return answer;
    }
    
    private long calcFactory(long a, long b) {
        if(b == 1) return a;
        return calcFactory(a * b, b - 1);
    }
    
    
}
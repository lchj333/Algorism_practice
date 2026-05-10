class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(; left <= right; left++) {
            if(getSmallNumsCount(left) % 2 == 0) {
                answer += left;
            }else {
                answer -= left;
            }
        }
        
        return answer;
    }
    
    public int getSmallNumsCount(int num) {
        // 기본적으로 1이 아니면 약수에 1과 자기자신 포함.
        int cnt = (num == 1 ? 1 : 2);
        for(int i = 2; i <= num / 2; i++) {
            if(num % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
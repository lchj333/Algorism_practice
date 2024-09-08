class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1; // 1 ≤ number ==> 1 무조건 포함

        for(int num = 2; num <= number; num++) {

            int cnt = 2; // 1과 자기자신 무조건 포함
            int harf = num / 2;

            for(int i = 2; i <= harf; i++) {
                if(num % i == 0) {
                    cnt += 1;
                }
            }

            if(limit < cnt)
                answer += power;
            else 
                answer += cnt;
        }

        return answer;
    }
}
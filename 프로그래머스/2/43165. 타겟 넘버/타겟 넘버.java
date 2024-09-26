class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }
    
    public int dfs(int[] numbers, int idx, int target, int value) {
        if(numbers.length <= idx) {
            if(target == value)
                return 1;
            else
                return 0;
            
        }else {
            int answer = 0;
            for(int multi = 1; multi > -2; multi -= 2) {
                answer += dfs(numbers, idx + 1, target, value + numbers[idx] * multi);
            }
            return answer;
        }
    }
}
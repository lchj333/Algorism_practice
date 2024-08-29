import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int first = 0; first < nums.length; first++) {

            for(int second = first+1; second < nums.length; second++) {

                for(int third = second+1; third < nums.length; third++) {

                    int sum = nums[first] + nums[second] + nums[third];
                    
                    boolean isAnswer = true;

                    for (int i = 2; i <= sum / 2; i++) {
                        if (sum % i == 0) {
                            isAnswer = false;
                            break;
                        }
                    }

                    if(isAnswer) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
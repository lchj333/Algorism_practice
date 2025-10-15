import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int answerIdx = numbers.length - 1;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int numsIdx = numbers.length - 1; -1 < numsIdx; numsIdx--) {
            
            if(stack.isEmpty()) {
                answer[answerIdx--] = -1;
                
            }else {
                boolean minusFlag = true;
                    
                while(! stack.isEmpty()) {
                    int stackNum = stack.peek();
                    if(stackNum > numbers[numsIdx]) {
                        answer[answerIdx--] = stackNum;
                        minusFlag = false;
                        break;
                    }else {
                        stack.pop();
                    }
                }
                
                if(minusFlag) {
                    answer[answerIdx--] = -1;
                }
            }

            stack.push(numbers[numsIdx]);
        }
        
        return answer;
    }
} 
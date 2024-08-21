import java.util.HashSet;
import java.util.Set;

class Solution {
    private final Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 예외 케이스
        numberSet.add(0);
        numberSet.add(1);

        // 다양한 길이 => 1, 12, 123 ...
        for(int idx = 1; idx <= numbers.length(); idx++) {
            answer += findCowNumber(numbers, "", idx);
        }

        return answer;
    }

    private int findCowNumber(String numbers, String item, int maxLen) {
        if(item.length() == maxLen) {
            int temp = Integer.parseInt(item);
            if(numberSet.contains(temp)) {
                return 0; // 중복된 소수.
            }else {
                numberSet.add(temp);
//                System.out.print(temp);
                for(int i = 2; i < temp; i++) {
                    if(temp % i == 0) {
//                        System.out.println(" return 0");
                        return 0;
                    }
                }
//                System.out.println(" return 1");
                return 1;
            }
        } else {
            int sum = 0;
            for(int i = 0; i < numbers.length(); i++) {
                sum += findCowNumber(numbers.substring(0, i) + numbers.substring(i+1, numbers.length()), item + numbers.substring(i, i+1), maxLen);
            }
            return sum;
        }
    }
}
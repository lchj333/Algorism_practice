package test;

import java.util.Arrays;

public class AddMissingNumbers {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer = 0;
        int numsIdx = 0;

        for (int integers = 0; integers < 10; integers++) {
            if(numbers.length > numsIdx && integers == numbers[numsIdx]) {
                numsIdx++;
            }else {
                answer += integers;
            }
        }

        return answer;
    }

    public int solution2(int[] numbers) {

        return 45 - Arrays.stream(numbers).sum();
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(new AddMissingNumbers().solution(numbers));
    }

}
/*
0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
*/
package test;

import java.util.Stack;

public class ReverseBase3 {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> base3 = new Stack<>();

        while(n / 3 > 0) {
            base3.add(n % 3);
            n /= 3;
        }
        base3.add(n);

        System.out.println("size : " + base3.size());
        for (int temp : base3) {
            System.out.print(temp + " ");
        }
        System.out.println();

        int idx = 0;
        while(!base3.isEmpty()) {
            answer += (Math.pow(3, idx++) * base3.pop());
        }
        /*
        for(int i = 0; i < base3.size(); i++) { //선입 후출
            System.out.print("i : " + i);
            answer += (Math.pow(3, i) * base3.pop());
            System.out.println(", answer : " + answer);
        }*/

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBase3().solution(125));
    }
}
/*
3진법 뒤집기 - https://school.programmers.co.kr/learn/courses/30/lessons/68935
    문제 설명
        자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

    제한사항
        n은 1 이상 100,000,000 이하인 자연수입니다.

    입출력 예
        n	    result
        45	    7
        125	    229

    입출력 예 설명
        입출력 예 #1
            답을 도출하는 과정은 다음과 같습니다.
            n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
            45	1200	0021	7
            따라서 7을 return 해야 합니다.

        입출력 예 #2
            답을 도출하는 과정은 다음과 같습니다.
            n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
            125	11122	22111	229
            따라서 229를 return 해야 합니다.
*/

package practice.algorism.programmers.lv2;

import java.util.Arrays;

public class BiggestInteger {
    public static void main(String[] args) {
        System.out.println(new BiggestInteger().solution(new int[] {6, 10, 2}));        // 6210
        System.out.println(new BiggestInteger().solution(new int[] {3, 30, 34, 5, 9})); // 9534330
        System.out.println(new BiggestInteger().solution(new int[] {1010,1})); // 11010
        System.out.println(new BiggestInteger().solution(new int[] {1213,12})); // 121312
        System.out.println(new BiggestInteger().solution(new int[] {1, 10, 100, 1000})); // 1101001000
        System.out.println(new BiggestInteger().solution(new int[] {0, 0, 0, 0})); // 0
    }

    public String solution(int[] numbers) {

        // compareTo를 위해 문자열로 변경
        String[] temp = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        // 정렬 (내림차순)
        Arrays.sort(temp, (o1, o2) -> {
            return compareArray(o1, o2);
        });

        // 정렬된 배열 결과 출력
        StringBuilder sb = new StringBuilder();
        for (String s : temp) {
            System.out.println(s);

            //입력값 {0, 0...} 악질 케이스 분기처리
            if(sb.length() == 0 && s.compareTo("0") == 0) {
                continue;
            }

            sb.append(s);
        }

        if(sb.isEmpty()) {
            sb.append("0");
        }

        return sb.toString();
    }

    public static int compareArray(String o1, String o2) {
        int minLen = Math.min(o1.length(), o2.length());
        for(int i = 0; i < minLen; i++) {

            int comp = o1.substring(i, i+1).compareTo(o2.substring(i, i+1));
            System.out.println(o1 + "["+o1.substring(i, i+1)+"], " + o2 + "["+o2.substring(i, i+1)+"], comp : " + (comp * -1));

            if(comp == 0) { // 비교값 같음

                if(i + 2 > o1.length()) {
                    if(i + 2 > o2.length()) {
                        // 길이 같음
                        System.out.println("i + 2 : " + (i + 2) + ", o1.length() : " + o1.length() + ", o2.length() : " + o2.length());
                        return 0;
                    }else {
                        // o1의 길이가 더 짧음 ex) 11 110 일 때, 11 과  11을 자른 0 을 다시 비교
                        System.out.println("compareArray("+o1+", "+o2.substring(i+1)+")");
                        return compareArray(o1, o2.substring(i+1));
                    }
                }

                if(i + 2 > o2.length()) {
                    if(i + 2 > o1.length()) {
                        // 길이 같음
                        System.out.println("i + 2 : " + (i + 2) + ", o1.length() : " + o1.length() + ", o2.length() : " + o2.length());
                        return 0;
                    }else {
                        // o2의 길이가 더 짧음
                        System.out.println("compareArray("+o1.substring(i+1)+", "+o2+")");
                        return compareArray(o1.substring(i+1), o2);
                    }
                }

            }else { // o1이 더 크거나 또는 o2가 더 큼
                return comp * -1; // 내림차순 정렬
            }
        }// for end
        // 길이, 문자 같음
        return 0;
    }
}
/*
가장 큰 수
https://school.programmers.co.kr/learn/courses/30/lessons/42746

문제 설명
    0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

    예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

    0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
    numbers의 길이는 1 이상 100,000 이하입니다.
    numbers의 원소는 0 이상 1,000 이하입니다.
    정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

입출력 예
numbers	            return
[6, 10, 2]	        "6210"
[3, 30, 34, 5, 9]	"9534330"
 */
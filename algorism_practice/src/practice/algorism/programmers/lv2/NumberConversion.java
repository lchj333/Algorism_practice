package practice.algorism.programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberConversion {
    public static void main(String[] args) {
        int[][] inputs = {{10, 40, 5, 2}
                        , {10, 40, 30, 1}
                        , {2, 5, 4, -1}};
        NumberConversion nc = new NumberConversion();
        for(int[] input : inputs) {
            int answer = nc.solution(input[0], input[1], input[2]);
            System.out.println("return " + answer + " : " + (input[3] == answer));
        }
    }

    public int solution(int x, int y, int n) {
        if(x == y) return 0;

        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[] {x, 0});
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < arrayList.size(); i++) {
            int[] data = arrayList.get(i);
            System.out.println("[" + data[0] + ", " + data[1] + "]");
            int q = data[0] * 3;
            int w = data[0] * 2;
            int e = data[0] + n;

            if(q == y || w == y || e == y) {
                return data[1] + 1;
            }
            addList(arrayList, hashSet, q, y, data[1] + 1);
            addList(arrayList, hashSet, w, y, data[1] + 1);
            addList(arrayList, hashSet, e, y, data[1] + 1);
        }

        return -1;
    }

    //중복 코드
    private void addList(ArrayList<int[]> arrayList, HashSet<Integer> hashSet, int nowVal, int target, int cnt) {
        if(nowVal < target) {
            if(hashSet.add(nowVal)) {
                arrayList.add(new int[] {nowVal, cnt});
            }
        }
    }
}

/*
숫자 변환하기
https://school.programmers.co.kr/learn/courses/30/lessons/154538

문제 설명
    자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

    x에 n을 더합니다
    x에 2를 곱합니다.
    x에 3을 곱합니다.
    자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요.
    이때 x를 y로 만들 수 없다면 -1을 return 해주세요.

제한사항
    1 ≤ x ≤ y ≤ 1,000,000
    1 ≤ n < y

입출력 예
    x	y	n	result
    10	40	5	2
    10	40	30	1
    2	5	4	-1

입출력 예 설명
    입출력 예 #1
        x에 2를 2번 곱하면 40이 되고 이때가 최소 횟수입니다.

    입출력 예 #2
        x에 n인 30을 1번 더하면 40이 되고 이때가 최소 횟수입니다.

    입출력 예 #3
        x를 y로 변환할 수 없기 때문에 -1을 return합니다.
 */
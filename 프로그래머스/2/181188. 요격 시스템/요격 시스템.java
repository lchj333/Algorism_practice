import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        //int[a][b] : a 오름차순 정렬
        Arrays.sort(targets, (o1, o2) -> o1[0] - o2[0]);

        int answer = 0;
        // 요격 미사일 방어 범위 초기화
        int rangeMin = -1;
        int rangeMax = -1;

        for(int t = 0; t < targets.length; t++) {
            int[] target = targets[t];

            if(rangeMin <= target[0] && rangeMax > target[0]) {
                // 커버 가능 구간 & 범위 재 설정
                rangeMin = Math.max(rangeMin, target[0]);
                rangeMax = Math.min(rangeMax, target[1]);
            }else {
                // 커버 불가능 -> 미사일 발사 추가
                rangeMin = target[0];
                rangeMax = target[1];
                answer++;
            }
        }

        return answer;
    }
}
class Solution {
    // 시간초과로 인한 서치 결과 : 투 포인터 알고리즘 사용
    public int[] solution(int[] sequence, int k) {
        int[] answer = null;
        int startIdx = 0;
        int endIdx = 0;
        int sum = sequence[0];
        
        do {
            // System.out.printf("[%d ~ %d] => %d\n", startIdx, endIdx, sum);
            if(k < sum) {
                if(startIdx < sequence.length - 1) {
                    sum -= sequence[startIdx++]; // 크면 시작인덱스 증가
                }else {
                    break;
                }
            }else if(k > sum) {
                if(endIdx < sequence.length - 1) {
                    sum += sequence[++endIdx]; // 작으면 마지막인덱스 증가
                }else {
                    break; // 의미없는 반복 EXIT
                }
            }else {
                if(answer == null) {
                    answer = new int[] {startIdx, endIdx};
                }else if((endIdx - startIdx) < (answer[1] - answer[0])) {
                    // 길이가 더 짧은 수열로 갱신
                    answer[0] = startIdx;
                    answer[1] = endIdx;
                }
                // System.out.printf("%d == %d, answer = {%d, %d}\n", sum, k, startIdx, endIdx);
                sum -= sequence[startIdx++]; // 다음 정답 찾기위해 시작인덱스 증가
            }
                
        } while(startIdx < sequence.length);
        
        return answer;
    }
    
}

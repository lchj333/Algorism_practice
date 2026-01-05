import java.util.*;

class Solution {
    
    class Ubak {
        final int value;
        final double surface;
        
        public Ubak(int value, double surface) {
            this.value = value;
            this.surface = surface;
        }
        
        public String toString() {
            return String.format("[value = %d, surface = %f]", value, surface);
        }
    }
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        // 우박 수열 리스트 생성
        List<Ubak> ubakList = new ArrayList<>();
        ubakList = calcUbakSurfaceUntilOne(ubakList, k);
        
        for(int rIdx = 0; rIdx < ranges.length; rIdx++) {
            int[] range = ranges[rIdx];
            
            range[0] = range[0];
            range[1] = ubakList.size() + range[1];

            if(range[0] >= range[1]) {
                // 시작점이 끝점 보다 큰 경우 -1 세팅 후 다음 탐색
                answer[rIdx] = -1;
                continue;
            }
            
            // x가 1일 경우 0~1구간의 면적 계산
            for(int x = range[1] - 1; x > range[0]; x--) {
                answer[rIdx] += ubakList.get(x).surface;
                // System.out.printf("%f ", answer[rIdx]);
            }
            // System.out.println();
        }
        
        // System.out.println(ubakList);
        
        return answer;
    }
    
    public List<Ubak> calcUbakSurfaceUntilOne(List<Ubak> ubakList, int k) {
        
        int input = k;
        ubakList.add(new Ubak(k, 0));
        
        while(input > 1) {
            // 우박 수열 값 구하기
            int resultValue = input % 2 == 0 ? input / 2 : input * 3 + 1;
            // 계산의 편의성을 위해 큰 값 체크
            double bigger = Math.max(input, resultValue);
            double smaller = Math.min(input, resultValue);
            // 면적 구하기
            double surface = smaller + (bigger - smaller) / 2;
            
            ubakList.add(new Ubak(resultValue, surface));
            
            input = resultValue;
        }
        
        return ubakList;
    }

}
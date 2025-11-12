import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        final int c = col - 1;
        Arrays.sort(data, (o1, o2) -> {
            if(o1[c] != o2[c])
                return o1[c] - o2[c];
            else
                return o2[0] - o1[0];
        });
        
        for(int i = row_begin - 1; i < row_end; i++) {
            int s = i + 1;
            int sum = 0;
            for(int d : data[i]) {
                sum += d % s;
            }
            answer ^= sum;
        }
        
        return answer;
    }
}
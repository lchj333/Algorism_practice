class Solution {
    public int solution(int[][] sizes) {
        int maxHorVal = 0;
        int maxVerVal = 0;

        for(int i = 0; i < sizes.length; i++) {
            // sizes[i][0] 위치에 긴 모서리로 설정
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            // 최대 가로, 세로 길이
            if(maxHorVal < sizes[i][0])
                maxHorVal = sizes[i][0];

            if(maxVerVal < sizes[i][1])
                maxVerVal = sizes[i][1];
        }

        return maxHorVal * maxVerVal;
    }
}
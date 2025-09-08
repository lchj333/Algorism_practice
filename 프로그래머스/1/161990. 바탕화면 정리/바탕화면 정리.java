class Solution {
    static final int LUY = 0;
    static final int LUX = 1;
    static final int RDY = 2;
    static final int RDX = 3;
    
    // 지문에 정수배열 [LUX, LUY, RDX, RDY]을 리턴 해야 하지만
    // 어째서 [LUY, LUX, RDY, RDX]를 리턴 해야 하는지 모르겠다...
    
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[LUX] = 50;
        answer[LUY] = 50;
        answer[RDX] = 0;
        answer[RDY] = 0;
        
        for(int y = 0; y < wallpaper.length; y++) {
            
            int firstFileIdx = wallpaper[y].indexOf("#");
            int lastFileIdx = wallpaper[y].lastIndexOf("#");
            
            // Y값 처리
            if(firstFileIdx > -1 || lastFileIdx > -1) {
                answer[LUY] = Math.min(answer[LUY], y);
                answer[RDY] = Math.max(answer[RDY], y);
            }
            
            // X값 처리
            if(firstFileIdx > -1 || lastFileIdx > -1) {
                answer[LUX] = Math.min(answer[LUX], firstFileIdx);
                answer[RDX] = Math.max(answer[RDX], lastFileIdx);
            }
        }
        
        // RDY + 1행 RDX + 1 까지 드래그
        answer[RDY]++;
        answer[RDX]++;
        
        return answer;
    }
}
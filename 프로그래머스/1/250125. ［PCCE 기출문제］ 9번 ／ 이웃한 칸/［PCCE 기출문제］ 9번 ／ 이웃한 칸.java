class Solution {
    
    private final int[] dy = {0, 0, 1, -1};
    private final int[] dx = {1, -1, 0, 0};
        
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        for(int i = 0; i < 4; i++) {
            int dh = h + dy[i];
            int dw = w + dx[i];
            if(checkLength(dh, board.length) && 
               checkLength(dw, board[dh].length) && 
               board[h][w].equals(board[dh][dw])) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean checkLength(int index, int length) {
        return -1 < index && index < length ? true : false;
    }
}
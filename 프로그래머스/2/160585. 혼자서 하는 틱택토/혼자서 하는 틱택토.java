class Solution {
    
    public int solution(String[] board) {
        // char array 변환
        char[][] cBoard = new char[board.length][];
        for(int i = 0; i < board.length; i++) {
            cBoard[i] = board[i].toCharArray();
        }
        
        BoardCount bc = getCountsOnBoard(cBoard);
        
        if(bc.cntO == bc.cntX) {
            // 'O'의 개수와    'X'의 개수가 같다면 'O'의 승리유무에 따라 결과 리턴
            // 'O'이 승리자라면 'X'가 실수함.
            return isThisGameWinner(cBoard, 'O') ? 0 : 1;
        }else if(bc.cntO -1 == bc.cntX) {
            // 'O'의 개수 보다 'X'의 개수가 한개 더 적을 때 'X'의 승리유무에 따라 결과 리턴
            // 'X'가 승리자라면 'O'이 실수함
            return isThisGameWinner(cBoard, 'X') ? 0 : 1;
        }else {
            // 그 외 무조건 실수
            return 0;
        }
    }
           
    // 보드판 위 개수 확인
    public BoardCount getCountsOnBoard(char[][] cBoard) {
        int cntO = 0;
        int cntX = 0;
        
        for(int y = 0; y < cBoard.length; y++) {
            for(int x = 0; x < cBoard[y].length; x++) {
                switch(cBoard[y][x]) {
                    case 'O': cntO++; break;
                    case 'X': cntX++; break;
                }
            }
        }
        
        return new BoardCount(cntO, cntX);
    }
    
    // 게임 승리자 인지 판단
    public boolean isThisGameWinner(char[][] cBoard, char player) {
        // 좌상 가로 세로
        if(cBoard[0][0] == player) {
            if(cBoard[0][0] == cBoard[0][1] && cBoard[0][1] == cBoard[0][2]) {
                return true;
            }else if(cBoard[0][0] == cBoard[1][0] && cBoard[1][0] == cBoard[2][0]) {
                return true;
            }
        }
        
        // 가운데 가로 세로 + 대각선
        if(cBoard[1][1] == player) {
            // 가로세로
            if(cBoard[1][0] == cBoard[1][1] && cBoard[1][1] == cBoard[1][2]) {
                return true;
            }else if(cBoard[0][1] == cBoard[1][1] && cBoard[1][1] == cBoard[2][1]) {
                return true;
            }
            // 대각
            if(cBoard[0][0] == cBoard[1][1] && cBoard[1][1] == cBoard[2][2]) {
                return true;
            }else if(cBoard[0][2] == cBoard[1][1] && cBoard[1][1] == cBoard[2][0]) {
                return true;
            }
        }
        
        // 우하 가로 세로
        if(cBoard[2][2] == player) {
            if(cBoard[2][0] == cBoard[2][1] && cBoard[2][1] == cBoard[2][2]) {
                return true;
            }else if(cBoard[0][2] == cBoard[1][2] && cBoard[1][2] == cBoard[2][2]) {
                return true;
            }
        }
        
        return false;
    }
    
    class BoardCount {
        public final int cntO;
        public final int cntX;
        
        public BoardCount(int cntO, int cntX) {
            this.cntO = cntO;
            this.cntX = cntX;
        }
    }
}
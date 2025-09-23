import java.util.*;

class Solution {
    static final char CHAR_START = 'S';
    static final char CHAR_EXIT  = 'E';
    static final char CHAR_LEVER = 'L';
    static final char CHAR_PASS  = 'O';
    static final char CHAR_WALL  = 'X';
    
    static final int[][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
    public int solution(String[] maps) {
        int answer = 0;
        
        char[][] charMap = new char[maps.length][];
        for(int i = 0; i < maps.length; i++) {
            charMap[i] = maps[i].toCharArray();
        }
        
        int[][] points = new int[3][2];
        int pointsIdx = 0;
        for(char target : new char[] {CHAR_START, CHAR_LEVER, CHAR_EXIT}) {
            points[pointsIdx++] = findPoint(maps, target);
        }
        
        for(int i = 0; i < points.length - 1; i++) {
            int moveCnt = getMoveCountToPoint(charMap, points[i], points[i+1]);
            if(-1 < moveCnt) { answer += moveCnt; }else { return -1; }
        }
            
        return answer;
    }
    
    // target지점의 위치정보 Get
    private int[] findPoint(String[] maps, char target) {
        for(int y = 0; y < maps.length; y++) {
            int x = maps[y].indexOf(target);
            
            if(-1 < x) {
                return new int[] {y, x};
            }
        }
        
        return null;
    }
    
    // 최단거리 탐색 메소드
    private int getMoveCountToPoint(char[][] map, int[] startPoint, int[] endPoint) {
        int moveCnt = 0;
        boolean[][] visited = new boolean[map.length][map[0].length]; // boolean default init => false
        
        Stack<int[]> stack = new Stack<>();
        Stack<int[]> subStack;
        stack.push(startPoint);
        
        while(! stack.isEmpty()) {
            moveCnt++;
            subStack = new Stack<>();
            
            while(! stack.isEmpty()) {
                int[] now = stack.pop();

                for(int i = 0; i < dxy.length; i++) {
                    int[] moved = {now[0] + dxy[i][0], now[1] + dxy[i][1]};
                    
                    if(isPossiblePoint(map, moved) && ! visited[moved[0]][moved[1]]) {
                        visited[moved[0]][moved[1]] = true;
                        if(endPoint[0] != moved[0] || endPoint[1] != moved[1]) {
                            subStack.push(moved);
                        }else {
                            return moveCnt;
                        }
                    }
                } // end for
            } // end inside while
            
            stack = subStack;
        } // end outside while
        
        return -1;
    }
    
    // 해당 좌표가 범위안의 통로인지 체크
    private boolean isPossiblePoint(char[][] map, int[] point) {
        return 0 <= point[0] && point[0] < map.length
                && 0 <= point[1] && point[1] < map[point[0]].length
                && map[point[0]][point[1]] != CHAR_WALL;
    }
}
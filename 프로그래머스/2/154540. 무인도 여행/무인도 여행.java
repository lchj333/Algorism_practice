import java.util.*;

class Solution {
    
    static final char SEA_CHAR = 'X';
    static final int SEA_INT = 0;
    static final int CHAR_ZERO = '0';
    static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        char[][] foodMap = new char[maps.length][];
        
        for(int y = 0; y < maps.length; y++) {
            // String -> char[]
            foodMap[y] = maps[y].toCharArray();
        } // map[y] for end
        
        for(int y = 0; y < foodMap.length; y++) {
            for(int x = 0; x < foodMap[y].length; x++) {
                // 해당 좌표가 섬이라면
                if(foodMap[y][x] != SEA_CHAR && foodMap[y][x] != CHAR_ZERO) { 
                    // dfs 탐색
                    answer.add(dfs(foodMap, y, x));
                }
            }
        }
        
        // System.out.println(answer);
        if(answer.isEmpty()) {
            return new int[] {-1};
        }else {
            return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
        }
    }

    public int dfs(char[][] foodMap, int y, int x) {
        
        int findFoods = (foodMap[y][x] - CHAR_ZERO);
        foodMap[y][x] = CHAR_ZERO;
        
        // 상, 하, 좌, 우 확인
        for(int[] d : directions) {
            int dy = y + d[0];
            int dx = x + d[1];
            if(0 <= dy && dy < foodMap.length && 0 <= dx && dx < foodMap[y].length 
                    && foodMap[dy][dx] != SEA_CHAR && foodMap[dy][dx] != CHAR_ZERO) {
                findFoods += dfs(foodMap, dy, dx);
            }
        }
        
        return findFoods;
    }
}
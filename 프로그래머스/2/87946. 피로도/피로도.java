import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int[] dungeon : dungeons) {
            queue.add(dungeon);
        }

        return intoNextDungeon(queue, k, dungeons.length, 0);
    }

    public int intoNextDungeon(Queue<int[]> queue, int k, int length, int path) {

        if(queue.isEmpty()) {
            // 모두 클리어!
            return path;
        }else {
            // 아직 남음..
            int maxPath = path;

            for(int i = 0; i < length; i++) {
                // 다음 던전 입장시 현재 던전을 제외
                int[] dungeon = queue.remove();

                if(k >= dungeon[0]) { // 더 클리어 가능!
                    maxPath = Math.max(maxPath, intoNextDungeon(queue, k - dungeon[1], length - 1, path + 1));
                }

                // 탐색 후 원위치
                queue.add(dungeon);
            }

            // 가장 많은 클리어 리턴
            return maxPath;
        }
    }
}
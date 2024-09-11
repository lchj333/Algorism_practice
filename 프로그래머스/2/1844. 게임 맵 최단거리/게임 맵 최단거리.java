import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visitList = new boolean[maps.length][maps[0].length];

        queue.add(new Point(0, 0, 1));
        visitList[0][0] = true;

        while(0 < queue.size()) {
            Point p = queue.remove();

            //도착지?
            if(p.y == maps.length -1 && p.x == maps[maps.length -1].length -1) {
                return p.route;
            }

            // 하
            if(maps.length > p.y + 1 && maps[p.y + 1][p.x] == 1) {
                addQueue(queue, visitList, p.y + 1, p.x, p.route+1);
            }

            // 우
            if(maps[0].length > p.x + 1 && maps[p.y][p.x + 1] == 1) {
                addQueue(queue, visitList, p.y, p.x + 1, p.route+1);
            }

            // 상
            if(0 <= p.y - 1 && maps[p.y - 1][p.x] == 1) {
                addQueue(queue, visitList, p.y - 1, p.x,p.route+1);
            }

            // 좌
            if(0 <= p.x - 1 && maps[p.y][p.x - 1] == 1) {
                addQueue(queue, visitList, p.y, p.x - 1,p.route+1);
            }

        }

        return -1;
    }

    public void addQueue(Queue queue, boolean[][] visitList, int y, int x, int route) {
        if (! visitList[y][x]) {
            queue.add(new Point(y, x, route));
            visitList[y][x] = true;
        }
    }

    class Point {
        public int y, x, route;

        public Point(int y, int x, int route) {
            this.y = y;
            this.x = x;
            this.route = route;
        }
    }
}
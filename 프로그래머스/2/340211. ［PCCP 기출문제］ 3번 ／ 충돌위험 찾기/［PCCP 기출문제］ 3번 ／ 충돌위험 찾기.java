import java.util.*;

class Solution {
    private Set<String> footPrintSet = new HashSet<>();     // 로봇들의 모든 경로
    private Set<String> brokenCheckSet = new HashSet<>();   // 충돌 포인트
    
    public int solution(int[][] points, int[][] routes) {

        int time = 0;
        List<Robot> robotList = new ArrayList<>();

        for(int[] route : routes) {
            // 로봇 생성
            int[] start = points[route[0] - 1];
            Robot robot = new Robot(start);

            // 시작지점 부터 충돌 가능
            recordFootPrint(time, start);

            // 도착 지점은?!
            for(int r = 1; r < route.length; r++) {
                robot.addFinish(points[route[r] - 1]);
            }

            robotList.add(robot);
        }

        time = 1;
        int finishCnt = 0;
        while(finishCnt < robotList.size()) {
            finishCnt = 0;
            
            for(Robot robot : robotList) {
                if(robot.hasFinish()) {
                    // 로봇 이동
                    int[] now = robot.moveToFinish();
                    recordFootPrint(time, now);
                }else{
                    finishCnt++;
                }
            }
            time++;
        }
        
        return brokenCheckSet.size();
    }
                      
    // 이동, 충돌 기록
    public void recordFootPrint(int time, int[] now) {
        String footPrint = String.format("%d %d %d", time, now[0], now[1]);
        if(! footPrintSet.add(footPrint)) {
            brokenCheckSet.add(footPrint);
        }
    }
}

class Robot {
    private int[] now;
    private int finishIdx = 0;
    private List<int[]> finishList = new ArrayList<>();

    public Robot(int[] now) {
        this.now = new int[] {now[0], now[1]}; // 깊은 복사.
    }

    public void addFinish(int[] finish) {
        finishList.add(finish);
    }

    public boolean hasFinish() {
        return finishIdx < finishList.size();
    }

    public int[] moveToFinish() { // 이동 시뮬레이션
        int[] finish = finishList.get(finishIdx);
        // 무조건 Y좌표 우선 이동이였어...
        if(now[0] != finish[0]) {   // Y 이동
            now[0] += finish[0] > now[0] ? 1 : -1;
        }else {                     // X 이동
            now[1] += finish[1] > now[1] ? 1 : -1;
        }
        
        // 목적지 재설정
        if(now[0] == finish[0] && now[1] == finish[1]) {
            finishIdx++;
        }

        return now;
    }
}
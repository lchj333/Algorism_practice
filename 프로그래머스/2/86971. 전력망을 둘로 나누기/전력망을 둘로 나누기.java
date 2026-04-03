import java.util.*;

class Solution {
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 송전탑 연결 정보를 담을 2차원 배열
        // 1   ~ 100 = wires를 기준으로 출발지 목적지
        // 101 ~ 200 = wires를 뒤집어서 목적지 출발지
        List<Integer>[] connInfoList = new List[201];
        for(int i = 0;  i < wires.length; i++) {
            int startingPoint = wires[i][0];
            int destination = wires[i][1];
            // 1 ~ 100
            setWireInfo(connInfoList, startingPoint, destination);
            // 101 ~ 200
            setWireInfo(connInfoList, destination+100, startingPoint);
        }
        
        // 가정: 트리구조에서 무조건 2덩이로 나뉜다
        // startingPoints[x] < startingPoints[x].get(y)
        for(int[] exclude : wires) {
            // 한 쪽 덩어리 완탐
            Set<Integer> myGroupSet = new HashSet<>();
            myGroupSet.add(1);
            upDfs(connInfoList, myGroupSet, exclude, 1);
        
            // 개수 차이 계산
            int minGroup = Math.min(n - myGroupSet.size(), myGroupSet.size());
            answer = Math.min(answer, n - 2 * minGroup);
        }
        
        return answer;
    }
    
    public void setWireInfo(List<Integer>[] connInfoList, int idx, int data) {
        List<Integer> destinations = connInfoList[idx];
        if(destinations == null) {
            destinations = new ArrayList<>();
            connInfoList[idx] = destinations;
        }
        destinations.add(data);
    }
    
    // 연결정보에서 현재 숫자보다 높은 숫자의 송전탑 탐색
    public void upDfs(List<Integer>[] connInfoList, Set<Integer> myGroupSet, int[] exclude, int idx) {
        if(connInfoList[idx] == null) { return; }
        
        for(int destination : connInfoList[idx]) {
            if(idx == exclude[0] && destination == exclude[1]) { continue; }
            
            if(myGroupSet.add(destination)) {
                downDfs(connInfoList, myGroupSet, exclude, destination+100);
                upDfs(connInfoList, myGroupSet, exclude, destination);
            }
        }
    }
    
    // 연결정보에서 현재 숫자보다 낮은 숫자의 송전탑 탐색
    public void downDfs(List<Integer>[] connInfoList, Set<Integer> myGroupSet, int[] exclude, int idx) {
        if(connInfoList[idx] == null) { return; }
        
        for(int destination : connInfoList[idx]) {
            if(idx == exclude[1]+100 && destination == exclude[0]) { continue; }
            
            if(myGroupSet.add(destination)) {
                upDfs(connInfoList, myGroupSet, exclude, destination);
                downDfs(connInfoList, myGroupSet, exclude, destination+100);
            }
        }
    }
}
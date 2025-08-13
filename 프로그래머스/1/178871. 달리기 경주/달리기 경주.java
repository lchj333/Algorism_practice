import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 플레이어 위치 정보 저장
        Map<String, Integer> playersMap = new HashMap<>();
        for(int idx = 0; idx < players.length; idx++) {
            playersMap.put(players[idx], idx);
        }
        
        for(String callingName : callings) {
            int calledPlayerIdx = playersMap.get(callingName);
            // 플레이어 위치 변경
            String nextPlayerName = players[calledPlayerIdx - 1];
            players[calledPlayerIdx - 1] = callingName;
            players[calledPlayerIdx] = nextPlayerName;
            // 플레이어 위치 정보 변경
            playersMap.put(nextPlayerName, calledPlayerIdx);
            playersMap.put(callingName, calledPlayerIdx - 1);
        }
        
        return players;
    }
    
}
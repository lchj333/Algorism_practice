class Solution {
    int TO_INT_ZERO = 48;
    
    public int solution(int storey) {
        int answer = 0;
        
        // int -> int[] 변환
        String strStorey = Integer.toString(storey);
        int[] floor = new int[strStorey.length() + 1];
        for(int x = 0; x < strStorey.length(); x++) {
            // ex) int[046362361]
            floor[x + 1] = strStorey.charAt(x) - TO_INT_ZERO;
        }
        // printArr(floor, answer);
        
        for(int x = floor.length - 1; x > 0; x--) {
            if(floor[x] < 5) {
                // 5보다 작으면 아래로 이동
                answer += floor[x];
            }else if(floor[x] == 5) {
                // 5와 같으면 앞자리 판별
                if(floor[x - 1] > 4) {
                    // 올라가는게 이득
                    answer += (10 - floor[x]);
                    frontNumInc(floor, x);
                }else {
                    // 내려가는게 이득
                    answer += floor[x];
                }
            }else {
                // 5 보다 높으면 위로 이동이 이득
                answer += (10 - floor[x]);
                frontNumInc(floor, x);
            }
            // floor[x] = 0;
            // printArr(floor, answer);
        }
        
        // 가장 앞의 자리수 계산
        answer += (floor[0] > 5 ? 10 - floor[0] + 1 : floor[0]);
        return answer;
    }
    
    // 앞자리 연쇄 증감 적용 메소드
    private void frontNumInc(int[] floor, int nowIdx) {
        for(int y = nowIdx - 1; y > -1; y--) {
            floor[y] += 1; // 앞자리 값 증가
            if(floor[y] == 10) { // check
                floor[y] = 0;
            }else {
               break; 
            }
        }
    }
    
    public void printArr(int[] floor, int answer) {
        for(int f : floor) {
            System.out.print(f);
        }
        System.out.println(", answer : " + answer);
    }
}
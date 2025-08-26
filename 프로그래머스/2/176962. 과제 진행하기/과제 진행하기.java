import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int answerIdx = 0;

        PriorityQueue<Assignment> assignmentPlansQueue 
                = new PriorityQueue<>((o1,o2) -> o1.startTime - o2.startTime); // 시작 할 시간 오름차순 정렬
        Stack<Assignment> remainAssignmentStack = new Stack<>();
        
        for(String[] plan : plans) { // 객체로 변환
            assignmentPlansQueue.add(new Assignment(plan[0], getMinuteTime(plan[1]), Integer.parseInt(plan[2])));
        }
 
        while( ! assignmentPlansQueue.isEmpty()) {
            
            Assignment nowAssignment = assignmentPlansQueue.poll(); // 현재 과제
            
            if( ! assignmentPlansQueue.isEmpty()) {
                // 다음 일정 있으면...
                int nextStartTime = assignmentPlansQueue.peek().startTime;
                int diff = nextStartTime - nowAssignment.startTime;
                
                // 현재 과제 시간 체크
                if(diff >= nowAssignment.playTime) {
                    // 현재 과제 수행 시간 충분
                    diff -= nowAssignment.playTime;
                    answer[answerIdx++] = nowAssignment.name;
                    
                    // 시간 더 남았을 때 보류 과제 체크
                    while(diff > 0) {
                        if(! remainAssignmentStack.isEmpty()) {
                            int remainPlayTime = remainAssignmentStack.peek().playTime;
                            
                            if(diff >= remainPlayTime) {
                                // 완료!
                                answer[answerIdx++] = remainAssignmentStack.pop().name;
                                
                            }else {
                                // 보류 과제 남은시간 갱신
                                remainAssignmentStack.peek().playTime = remainPlayTime - diff;
                            } // time check if end
                            
                            diff -= remainPlayTime;
                        }else {
                            diff = 0;
                        } // stack check if end
                    } // inside while end
                    
                }else {
                    // 남은 시간 갱신 후 보류
                    nowAssignment.playTime -= diff;
                    remainAssignmentStack.push(nowAssignment);
                }
            }else { // 다음 일정 없으면 무조건 완료
                answer[answerIdx++] = nowAssignment.name;
            }

        } // outside while end
        
        // 남아있는 과제 순서대로 처리
        while( ! remainAssignmentStack.isEmpty()) {
            answer[answerIdx++] = remainAssignmentStack.pop().name;
        }

        return answer;
    }

    private int getMinuteTime(String time) {
        return getMinuteTime(Integer.parseInt(time.replace(":", "")));
    }

    private int getMinuteTime(int time) {
        return time / 100 * 60 + time % 100;
    }

    class Assignment {
        String name;
        int startTime;
        int playTime;
        
        public Assignment(String name, int playTime) {
            this(name, 0, playTime);
        }

        public Assignment(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }

        @Override
        public String toString() {
            return "{name=" + name + ", startTime=" + startTime + ", playTime=" + playTime + '}';
        }
    }
}
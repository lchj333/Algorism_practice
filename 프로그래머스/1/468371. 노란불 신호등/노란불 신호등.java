import java.util.*;
    
class Solution {
    public int solution(int[][] signals) {
        // 객체 변환
        Signal[] signalArr = new Signal[signals.length];
        for(int i = 0; i < signals.length; i++) {
            signalArr[i] = new Signal(signals[i]);
        }
        
        int maxTime = Integer.MAX_VALUE - 20;
        while(signalArr[0].getCurrentYellowTime().last < maxTime) {
            TimeInfo yellowInfo = signalArr[0].getCurrentYellowTime();
            // System.out.printf("[%d] { %s }%n", 0, yellowInfo);
            
            for(int i = 0 + 1; i < signals.length; i++) {
                TimeInfo tempInfo = signalArr[i].getCurrentYellowTime();
                while(tempInfo.last < yellowInfo.start) {
                    tempInfo = signalArr[i].getNextYellowTime();
                }
                
                // System.out.printf("[%d] { startY=%d, lastY=%d }%n", i, yellowInfo.start, yellowInfo.last);
                if(yellowInfo.start <= tempInfo.last && yellowInfo.last >= tempInfo.start) {
                    yellowInfo.start = Math.max(yellowInfo.start, tempInfo.start);
                    yellowInfo.last = Math.min(yellowInfo.last, tempInfo.last);
                }else {
                    // System.out.printf("[%d] break!%n", i);
                    break;
                }
                
                if(i == signals.length - 1) {
                    return yellowInfo.start;
                }
            }
            
            signalArr[0].getNextYellowTime();
        }
        
        return -1;
    }
    
    class Signal {
        public final int sumGreenRed;
        public final int yellowTimeRange;
        private int startY;
        private int lastY;
        
        public Signal(int[] arr) {
            this(arr[0], arr[1], arr[2]);
        }
        
        public Signal(int G, int Y, int R) {
            sumGreenRed = G + R;
            yellowTimeRange = Y - 1;
            startY = G + 1;
            lastY = startY + yellowTimeRange;
        }
        
        public TimeInfo getCurrentYellowTime() {
            return new TimeInfo(startY, lastY);
        }
        
        public TimeInfo getNextYellowTime() {
            startY += yellowTimeRange + sumGreenRed + 1;
            lastY = startY + yellowTimeRange;
            return new TimeInfo(startY, lastY);
        }
    }
    
    class TimeInfo {
        public int start;
        public int last;
        
        public TimeInfo(int start, int last) {
            this.start = start;
            this.last = last;
        }
        
        public String toString() {
            return "{ start=" + start + ", last=" + last + " }";
        }
    }
}
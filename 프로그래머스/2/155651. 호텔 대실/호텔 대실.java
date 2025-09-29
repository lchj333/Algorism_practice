import java.util.*;

class Solution {
    
    static final int CLEANING_MINUTE = 10;
    
    public int solution(String[][] book_time) {
        // 변환
        Reservation[] customers = new Reservation[book_time.length];
        for(int i = 0; i < book_time.length; i++) {
            String[] book = book_time[i];
            customers[i] = new Reservation(parseToIntTime(book[0]), parseToIntTime(book[1]));
        }
        
        // 오름차순 정렬
        Arrays.sort(customers);
        
        // 예약정보만큼 반복
        List<List<Reservation>> rooms = new ArrayList<>();
        for(Reservation customer : customers) {
            int conflictCount = 0;
            // 방 개수만큼 탐색
            for(List<Reservation> room : rooms) {
                boolean conflictFlag = false;
                for(Reservation rv : room) {
                    // 예약 겹치나?
                    if(rv.isConflictOther(customer, CLEANING_MINUTE)) {
                        conflictCount++;
                        conflictFlag = true;
                        break; // room for out
                    }
                } // room for end
                
                // 현재 방 예약들과 안겹치면 예약 넣기
                if( ! conflictFlag) {
                    room.add(customer);
                    break; // rooms for out
                }
                    
                // 다음 방
            } // rooms for end
                
            // 모두 겹치나?
            if(rooms.size() == conflictCount) {
                // 방 생성
                List<Reservation> newRoom = new ArrayList<>();
                newRoom.add(customer);
                rooms.add(newRoom);
            }
        } // bookIntTimes for end
        
        // print test
        // for(List<Reservation> room : rooms) {
        //     System.out.println(room);
        // }
        
        return rooms.size();
    }
    
    public int parseToIntTime(String strTime) {
        String[] splitSrtTime = strTime.split(":");
        return Integer.parseInt(splitSrtTime[0]) * 60 + Integer.parseInt(splitSrtTime[1]);
    }
    
    class Reservation implements Comparable<Reservation> {
        private int startTime;
        private int endTime;
        
        public Reservation(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        public boolean isConflictOther(Reservation other, int cleaningMinute) {
            int thisStartTime = startTime - cleaningMinute;
            int thisEndTime = endTime + cleaningMinute;
            
            return ! (other.endTime <= thisStartTime || thisEndTime <= other.startTime);
        }
        
        @Override
        public int compareTo(Reservation o) {
            if(startTime != o.startTime) {
                return startTime - o.startTime;
            }else {
                return endTime - o.endTime;
            }
        }
        
        @Override
        public String toString() {
            return String.format("{start=%d, end=%d}", startTime, endTime);
        }
    }
}
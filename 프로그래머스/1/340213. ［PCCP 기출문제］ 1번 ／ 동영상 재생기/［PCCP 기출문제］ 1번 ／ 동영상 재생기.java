class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        // 초단위 변환
        int videoEndSec = getVideoSeconds(video_len);
        int nowSec = getVideoSeconds(pos);
        int opStartSec = getVideoSeconds(op_start);
        int opEndSec = getVideoSeconds(op_end);

        // 현재 시점 오프닝 건너뛰기
        nowSec = skipOpening(nowSec, opStartSec, opEndSec);

        // 커맨드 처리
        for(String command : commands) {
            switch (command) {
                case "next" :
                    if(nowSec + 10 < videoEndSec) {
                        nowSec += 10;
                    }else {
                        nowSec = videoEndSec;
                    }
                    break;
                case "prev" :
                    if(nowSec - 10 > 0) {
                        nowSec -= 10;
                    }else {
                        nowSec = 0;
                    }
                    break;
            }

            // 커맨트 처리 후 오프닝 건너뛰기
            nowSec = skipOpening(nowSec, opStartSec, opEndSec);
        }

        return getVideoTimeString(nowSec);
    }

    // String -> Integer
    private int getVideoSeconds(String timeStr) {
        String[] videoTimes = timeStr.split(":");
        return (Integer.parseInt(videoTimes[0]) * 60) + Integer.parseInt(videoTimes[1]);
    }

    // 오프닝 건너뛰기
    private int skipOpening(int nowSec, int opStartSec, int opEndSec) {
        return (opStartSec <= nowSec && nowSec < opEndSec) ? opEndSec : nowSec;
    }

    // Integer -> String
    private String getVideoTimeString(int seconds) {
        StringBuilder sb = new StringBuilder();

        int minute = seconds / 60;
        seconds = seconds % 60;

        return sb.append(minute < 10 ? "0" : "").append(minute)
                .append(":")
                .append(seconds < 10 ? "0" : "").append(seconds)
                .toString();
    }
}
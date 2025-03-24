class Solution {
    
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        // 초단위 변환
        val videoEndSec = getVideoSeconds(video_len);
        var nowSec = getVideoSeconds(pos);
        val opStartSec = getVideoSeconds(op_start);
        val opEndSec = getVideoSeconds(op_end);

        // 현재 시점 오프닝 건너뛰기
        nowSec = skipOpening(nowSec, opStartSec, opEndSec);

        // 커맨드 처리
        for(command in commands) {
            when (command) {
                "next" ->
                    if(nowSec + 10 < videoEndSec) {
                        nowSec += 10;
                    }else {
                        nowSec = videoEndSec;
                    }
                "prev" -> 
                    if(nowSec - 10 > 0) {
                        nowSec -= 10;
                    }else {
                        nowSec = 0;
                    }
            }

            // 커맨트 처리 후 오프닝 건너뛰기
            nowSec = skipOpening(nowSec, opStartSec, opEndSec);
        }

        return getVideoTimeString(nowSec);
    }

    // String -> Integer
    fun getVideoSeconds(timeStr: String): Int {
        val videoTimes = timeStr.split(":")
        return (Integer.parseInt(videoTimes[0]) * 60) + Integer.parseInt(videoTimes[1]);
    }

    // 오프닝 건너뛰기
    fun skipOpening(nowSec: Int, opStartSec: Int, opEndSec: Int): Int {
        return if(opStartSec <= nowSec && nowSec < opEndSec) { opEndSec } else { nowSec }
    }

    // Integer -> String
    fun getVideoTimeString(seconds: Int): String {
        val minuteInt = seconds / 60
        val secondsInt = seconds % 60

        val minuteStr = if(minuteInt < 10) { "0$minuteInt" } else { minuteInt.toString() }
        val secondsStr = if(secondsInt < 10) { "0$secondsInt" } else { secondsInt.toString() }

        return "$minuteStr:$secondsStr"
    }
}
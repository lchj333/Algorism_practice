class Solution {

    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = 0

        var targetTimes = timelogs[0].size
        var nowDay = startday
        val notLateCntList = IntArray(timelogs.size) { 0 }

        for(y in 0 .. timelogs[0].size - 1) {

            if(nowDay < 6) {

                for(x in 0 .. timelogs.size - 1) {

                    notLateCntList[x] = if(schedules[x].isNotLate(timelogs[x][y])) { 
                        notLateCntList[x] + 1 
                    }else { 
                        notLateCntList[x] 
                    }
                }

            }else {
                targetTimes--
            }

            nowDay = if(++nowDay > 7) { 
                nowDay % 7 
            }else { 
                nowDay 
            }

        }

        for(i in 0 .. notLateCntList.size - 1) {

            if(notLateCntList[i] == targetTimes) { answer++ }
        }

        return answer
    }

    fun Int.isNotLate(commuteTime: Int): Boolean {
        val plusedTime = this + 10

        val chkHours = plusedTime / 100 + if((plusedTime % 100) / 60 > 0) { 1 } else { 0 }
        val chkMinutes = (plusedTime % 100) % 60

        return (chkHours > commuteTime / 100) || (chkHours == commuteTime / 100 && chkMinutes >= commuteTime % 100)
    }
}
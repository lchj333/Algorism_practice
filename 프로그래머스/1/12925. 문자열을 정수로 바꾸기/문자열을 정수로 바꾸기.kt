class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var multi = 1
        var subStr = s
        
        if(s.substring(0..1).equals("-")) {
            multi = -1
            subStr = subStr.substring(1)
        }
        
        answer = multi * s.toInt()
        return answer
        
    }
}
class Solution {
    fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
        val answer = mutableListOf<Int>()

        for(str in intStrs) {
            val sub = str.substring(s, s + l).toInt()

            if(sub > k) answer.add(sub)
        }
        return answer.toIntArray()
    }
}
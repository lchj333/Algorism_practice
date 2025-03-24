class Solution {
    fun solution(arr: IntArray, query: IntArray): IntArray {
        var answer: IntArray = arr

        for(idx in 0 .. query.size - 1) {
            val q = query[idx]

            answer = if(idx % 2 == 0) {
                answer.copyOfRange(0, q + 1)
            }else {
                answer.copyOfRange(q, answer.size)
            }
        }
        
        return answer
    }
}
class Solution {
    fun solution(n: Int): Array<IntArray> {
        val answer: Array<IntArray> = Array(n) { IntArray(n) {0} }

        var x = 0
        var y = 0
        var direction = 0
        val dx = arrayOf(0, 1, 0, -1)
        val dy = arrayOf(1, 0, -1, 0)
        var num = 1

        while(num <= n * n) {
            answer[x][y] = num++

            var tempX = x + dx[direction]
            var tempY = y + dy[direction]

            if(tempX < 0 || n-1 < tempX || tempY < 0 || n -1 < tempY || answer[tempX][tempY] != 0) {
                direction = (direction + 1) % 4
                tempX = x + dx[direction]
                tempY = y + dy[direction]
            }

            x = tempX
            y = tempY
        }

        return answer
    }
}
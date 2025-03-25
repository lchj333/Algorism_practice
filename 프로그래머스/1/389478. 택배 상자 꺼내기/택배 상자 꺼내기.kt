class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 0

        var x = 0
        var direction = 0
        val dx = intArrayOf(1 ,-1)
        var targetX = 0
        var item = 1
        val storage = Array(w) { mutableListOf<Int>() }

        while(item <= n) {
            if(item == num) { targetX = x }

            storage[x].add(item++)

            x += dx[direction]

            if( 0 > x || x >= w) {
                direction = (direction + 1) % 2
                x += dx[direction]
            }
        }

        return storage[targetX].size - storage[targetX].indexOfFirst { it == num }
    }
}
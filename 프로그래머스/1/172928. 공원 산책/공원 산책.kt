class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val now = Location()

        // 2차원배열 변환
        for(i in 0 .. park.size - 1) {

            // 시작지점 찾기
            if(park[i].contains("S")) {
                now.x = park[i].indexOfFirst { it == 'S' }
                now.y = i
                break
            }
        }

        // 명령수행
        for (r in routes) {
            val route = r.split(" ")

            // 동서남북
            when(route[0]) {
                "E" -> {
                    // 벗어남 체크
                    if(now.x + route[1].toInt() < park[now.y].length) {
                        // 장애물 체크
                        var isPossible = true
                        for(x in now.x .. now.x + route[1].toInt()) {
                            if(park[now.y][x] == 'X') { isPossible = false; break }
                        }
                        if(isPossible) {
                            now.x += route[1].toInt()
                        }
                    }
                }
                "W" -> {
                    // 벗어남 체크
                    if(now.x + (route[1].toInt() * -1) > -1) {
                        // 장애물 체크
                        var isPossible = true
                        for(x in now.x + (route[1].toInt() * -1) .. now.x) {
                            if(park[now.y][x] == 'X') { isPossible = false; break }
                        }
                        if(isPossible) {
                            now.x += (route[1].toInt() * -1)
                        }
                    }
                }
                "S" -> {
                    // 벗어남 체크
                    if(now.y + route[1].toInt() < park.size) {
                        // 장애물 체크
                        var isPossible = true
                        for(y in now.y .. now.y + route[1].toInt()) {
                            if(park[y][now.x] == 'X') { isPossible = false; break }
                        }
                        if(isPossible) {
                            now.y += route[1].toInt()
                        }
                    }
                }
                "N" -> {
                    // 벗어남 체크
                    if(now.y + (route[1].toInt() * -1) > -1) {
                        // 장애물 체크
                        var isPossible = true
                        for(y in now.y + (route[1].toInt() * -1) .. now.y) {
                            if(park[y][now.x] == 'X') { isPossible = false; break }
                        }
                        if(isPossible) {
                            now.y += (route[1].toInt() * -1)
                        }
                    }
                }

            }

        }

        return now.getIntArray()
    }

    data class Location(var y: Int = 0, var x: Int = 0) {
        fun getIntArray(): IntArray {
            return intArrayOf(y, x)
        }
    }
}
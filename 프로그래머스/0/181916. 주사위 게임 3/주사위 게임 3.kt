class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        var answer = 0

        var maxEqualCnt = 0
        var mainEqualInput = 0
        var subEqualInput = 0
        val equalArray = Array(7) {0}

        for(input in arrayOf(a, b, c, d)) {
            // 인덱스 카운트 증감
            if(++equalArray[input] > maxEqualCnt) {
                maxEqualCnt = equalArray[input]
                mainEqualInput = input;
            }
            // 2, 2 씩 같은 경우
            if(maxEqualCnt == 2 && equalArray[input] == 2 && input != mainEqualInput) {
                subEqualInput = input;
            }
        }

        when(maxEqualCnt) {
            4 -> answer = 1111 * mainEqualInput // 1111 * p
            3 -> { // (10 * p + q)(10 * p + q)
                answer = (10 * mainEqualInput) + equalArray.indexOfFirst { it == 1 }
                answer *= answer
            }
            2 -> {
                if(subEqualInput > 0) { // p + q * |p - q|
   
                    answer = (mainEqualInput + subEqualInput) * (mainEqualInput - subEqualInput);
                    answer = if (answer < 0) { answer * -1 } else { answer }
                }else { // q * r
                    answer = equalArray.indexOfFirst { it == 1 } * equalArray.indexOfLast { it == 1 }
                }
            }
            1 -> answer = equalArray.indexOfFirst { it == 1 } // min value
        }

        return answer
    }
}
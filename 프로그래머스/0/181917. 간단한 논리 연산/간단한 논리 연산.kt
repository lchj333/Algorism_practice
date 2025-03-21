class Solution {
    fun solution(x1: Boolean, x2: Boolean, x3: Boolean, x4: Boolean): Boolean {
        return andOperation(orOperation(x1, x2), orOperation(x3, x4))
    }

    fun orOperation (p1: Boolean, p2: Boolean): Boolean {
        return p1 || p2
    }

    fun andOperation (m1: Boolean, m2: Boolean): Boolean {
        return m1 && m2
    }
}
class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for(int x = 0; x <= d; x += k) {
            long maxY = getMaxY(d, x);
            // System.out.println("x = " + x + ", maxY = " + (Math.sqrt(d*d - x*x)) + ", result = " + (Math.sqrt(d*d - x*x) / k));
            answer += maxY / k + 1;
        }

        return answer;
    }
    
    // Y <= √(D*D - X*X)
    public long getMaxY(long d, long x) {
        return (long) Math.sqrt(d*d - x*x);
    }
}
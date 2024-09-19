class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        for(int tmpCol = sum / 2 - 1; tmpCol > 2; tmpCol--) {
            if(sum % tmpCol == 0) {
                int tmpRow = sum / tmpCol;

                if((tmpRow -2) * (tmpCol -2) == yellow) {
                    return new int[] {tmpCol, tmpRow};
                }
            }
        }

        return new int[] {0, 0};
    }
}
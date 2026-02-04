import java.util.*;

class Solution {
    public int solution(int[] elements) {
        List<Integer> elementList = new ArrayList<>();
        Set<Integer> elementSumSet = new HashSet<>();

        for(int i = 1; i <= 2; i++) {
            for(int e : elements) {
                elementList.add(e);
            }
        }

        int sumLength = 1;
        while(sumLength <= elements.length) {
            for(int start = 0; start < elements.length; start++) {
                int elementSum = 0;
                for(int idx = start; idx < start + sumLength; idx++) {
                    elementSum += elementList.get(idx);
                    // System.out.printf("%d ", elementList.get(idx));
                }
                // System.out.printf("Sum = %d%n", elementSum);
                elementSumSet.add(elementSum);
            }
            sumLength++;
        }

        return elementSumSet.size();
    }
}
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int commonIntA = arrayA[0];
        int commonIntB = arrayB[0];
            
        for(int idx = 1; idx < arrayA.length; idx++) {
            // System.out.printf("arrayA (%d, %d), common : ", commonIntA, arrayA[idx]);
            commonIntA = findCommonInt(arrayA[idx], commonIntA);
            // System.out.printf("%d | arrayB (%d, %d), common : ", commonIntA, commonIntB, arrayB[idx]);
            commonIntB = findCommonInt(arrayB[idx], commonIntB);
            // System.out.printf("%d%n", commonIntB);
        }
        
        // 최대 공약수가 1이면 정답이 될 수 없다.
        boolean isUniqueA = commonIntA == 1 ? false : true;
        boolean isUniqueB = commonIntB == 1 ? false : true;
        
        // 최대 공약수의 조건 만족 확인
        for(int idx = 0; idx < arrayA.length; idx++) {
            if(isUniqueA && arrayB[idx] % commonIntA == 0) {
                isUniqueA = false;
            }
            
            if(isUniqueB && arrayA[idx] % commonIntB == 0) {
                isUniqueB = false;
            }
            
            if(! isUniqueA && ! isUniqueB) {
                break;
            }
        }
        
        if(isUniqueA && isUniqueB) {
            return Math.max(commonIntA, commonIntB);
        } if(! isUniqueA && ! isUniqueB) {
            return 0;
        }else if(isUniqueA) {
            return commonIntA;
        }else {
            return commonIntB;
        }
    }
    
    // 최대 공약수 찾기
    public int findCommonInt(int bigger, int smaller) {
        int exchange = bigger % smaller;
        return exchange == 0 ? smaller : findCommonInt(smaller, exchange);
    }
}
import java.util.*;

class Solution {
    static final Set<Long> primeSet = new HashSet<>();
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] knums = Integer.toString(n, k).split("0");
        // System.out.println(Arrays.toString(knums));
        
        for(String knum : knums) {
            if(knum.length() == 0) continue;
            
            long num = Long.parseLong(knum);
            // System.out.println(num);
            
            if(num == 1) { 
                continue;
            }
            
            if(primeSet.contains(num) || num <= 3) {
                answer++;
                continue;
            }
            
            boolean isPrime = true;
            for(long i = 2; i < Math.sqrt(num) + 1; i++) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime) {
                primeSet.add(num);
                answer++;    
            }
        }
        
        return answer;
    }
}
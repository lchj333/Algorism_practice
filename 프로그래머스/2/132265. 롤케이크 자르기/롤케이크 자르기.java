import java.util.*;

class Solution {
    class RollCake {
        final int[] toppingNums = new int[10001];
        final Set<Integer> toppingTypes = new HashSet<>();
        
        public RollCake() {}
        public RollCake(int[] toppings) {
            for(int topping : toppings) {
                toppingNums[topping]++;
                toppingTypes.add(topping);
            }
        }
        
        public void removeTopping(int topping) {
            if(toppingNums[topping] > 0) {
                toppingNums[topping]--;
                
                if(toppingNums[topping] == 0) {
                    toppingTypes.remove(topping);
                }
            }
        }
        
        public void addTopping(int topping) {
            toppingNums[topping]++;
            toppingTypes.add(topping);
        }
        
        public int getNumberOfToppingTypes() {
            return toppingTypes.size();
        }
    }
    
    
    public int solution(int[] topping) {
        int answer = 0;
        
        RollCake older = new RollCake(topping);
        RollCake younger = new RollCake();
        
        for(int topp : topping) {
            older.removeTopping(topp);
            younger.addTopping(topp);
            if(older.getNumberOfToppingTypes()
               == younger.getNumberOfToppingTypes()) {
                answer++;
            }
            
        }
        
        return answer;
    }
}
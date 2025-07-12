class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int rastAttackTime = 0;
        for(int[] attack : attacks) {
            // use bandage before attack
            // 타격받는 시간은 붕대 감기가 취소되는 시간 제외 계산이므로 -1
            int bandageTime = attack[0] - rastAttackTime -1;
            health += bandageTime * bandage[1];
            if(bandageTime >= bandage[0]) { 
                // 연속 성공 고려
                health += (bandageTime / bandage[0]) * bandage[2];
            }
            
            // check my health
            health = Math.min(health, maxHealth);
                
            // damaged!!
            health -= attack[1];
            // am i dead?
            if(health <= 0) {
                return -1;
            }
                
            // set History
            rastAttackTime = attack[0];
        }
        
        return health;
    }
}
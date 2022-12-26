package test;

import java.util.HashMap;
import java.util.Map;

public class Phoneketmon {
    public int solution(int[] nums) {
        int length = nums.length;
        int maxSelect = length / 2;
        int kinds = 0;

        Map<Integer, Integer> monsterMap = new HashMap<Integer, Integer>();
        for (int mon : nums) {
            int cnt = 1;
            if(null != monsterMap.get(mon)){
                cnt = monsterMap.get(mon);
                ++cnt;
            }else{
                ++kinds;
            }
            monsterMap.put(mon, cnt);
        }

        return kinds > maxSelect ? maxSelect : kinds;
    }

    public static void main(String[] args) {
        int[] param = {1,1,2,3,4};
        int result = new Phoneketmon().solution(param);
        System.out.println("result : " + result);
    }
}

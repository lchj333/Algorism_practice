import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList<String>> clothesMap = new HashMap<String, ArrayList<String>>(); 
        
        for(String[] clotheInfo : clothes) {
        	ArrayList<String> list = clothesMap.get(clotheInfo[1]);
        	if(list == null) {
        		list = new ArrayList<String>();
        		clothesMap.put(clotheInfo[1], list);
        		list.add("unequip");
        	}
        	list.add(clotheInfo[0]);
        }
        
        // System.out.println("KeySet : " + clothesMap.keySet());
        for(String key : clothesMap.keySet()) {
        	answer *= clothesMap.get(key).size();
        	// System.out.println(key + " : " + clothesMap.get(key).toString());
        }
        return answer - 1;
    }
}
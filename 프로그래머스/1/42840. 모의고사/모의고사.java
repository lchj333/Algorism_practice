import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] checks = {0,0,0};
		int max = 0;
		
		int[][] omrs = {{1, 2, 3, 4, 5}, 
						{2, 1, 2, 3, 2, 4, 2, 5}, 
						{3, 3, 1, 1, 2, 2, 4, 4, 5, 5} };
		
        for(int aIdx=0; answers.length>aIdx; aIdx++) {
        	
        	for(int oIdx=0; omrs.length>oIdx; oIdx++) {
        		int chkIdx = aIdx % omrs[oIdx].length;
        		
	        	if(answers[aIdx] == omrs[oIdx][chkIdx]) {
	        		checks[oIdx]+=1;
	        		
	        		if(max < checks[oIdx]) {
		        		max = checks[oIdx];
		        	}
	        	}
	        	
        	}
        }
        
        ArrayList<Integer> arrList = new ArrayList<>();
    	for(int x=0; checks.length>x; x++) {
    		if(max == checks[x]) {
    			arrList.add(x+1);
    		}
    	}
        
    	int[] result = new int[arrList.size()];
    	for(int x=0; result.length>x; x++) {
    		result[x] = arrList.get(x);
    	}
        
        return result;
    }
}
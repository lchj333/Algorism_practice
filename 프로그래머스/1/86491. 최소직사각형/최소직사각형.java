class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int ver = 0;
        int hor = 0;
        
        //NO 위치 변경
        for(int i = 0; i < sizes.length; i++) {
        	int[] temp = sizes[i];
        	
        	if(ver < temp[0]) {
        		ver = temp[0];
        	}
        	
        	if(hor < temp[1]) {
        		hor = temp[1];
        	}
        }
        
        answer = ver * hor;
        ver = 0;
        hor = 0;
        
        //YES 위치 변경
        for(int j = 0; j < sizes.length; j++) {
        	//돌리기
        	int temp = sizes[j][0];
        	sizes[j][0] = sizes[j][1];
        	sizes[j][1] = temp;
        	
        	// 사이즈 찾기
        	for(int i = 0; i < sizes.length; i++) {
        		int[] size = sizes[i];
        		
        		if(ver < size[0]) {
        			ver = size[0];
        		}
        		
        		if(hor < size[1]) {
        			hor = size[1];
        		}
        	}
        	
        	//원위치
        	sizes[j][0] = sizes[j][1];
        	sizes[j][1] = temp;
        	
        	//정답은?
        	answer = Math.min(answer, ver*hor);
        }
        
        return answer;
    }
}
package test;

import java.util.ArrayList;
import java.util.List;

public class NoEqulsNum {
	//입출력 예) 
	//		1,2,2,3,3,5  ===> 1,2,3,5
	public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        int temp = -1;
        for(int x=0; x<arr.length; x++) {
        	if(temp != arr[x]) list.add(arr[x]);
        	temp = arr[x];
        }
        
        int[] answer = new int[list.size()];
        for(int x=0; x<list.size(); x++) {
        	answer[x] = list.get(x);
        }
        return answer;
    }
	
}

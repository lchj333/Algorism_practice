class Solution {
    public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int i=0; commands.length>i; i++) {
			int[] tempArr = cuttingArray(array, commands[i]);
						
			tempArr = shortArray(tempArr);
			
			answer[i] = tempArr[commands[i][2]-1];
		}
		
		return answer;
	}
	private int[] cuttingArray(int[] array, int[] command) {
		int[] result = new int[command[1] - command[0] + 1];
		int idx = 0;
		for(int x=command[0]-1; command[1]>x; x++) {
			result[idx] = array[x];
			idx++;
		}
		return result;
	}
	private int[] shortArray(int[] array) {
		int[] tempArr = array;
		for(int y=0; tempArr.length-1>y; y++) {
			for(int x=y+1; tempArr.length>x; x++) {
				if(tempArr[y]>tempArr[x] ) {
					int temp = tempArr[x];
					tempArr[x] = tempArr[y];
					tempArr[y] = temp;
				}
			}
		}
		return tempArr;
	}
}
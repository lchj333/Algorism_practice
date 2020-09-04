package test;

public class Sum_TwoNums {
	//두 수 사이의 합 ex)3~5 = 12
	public long solution(int a, int b) {
		long answer = 0;
        for(int i=(Math.min(a, b)); i<=(Math.max(a, b)); i++) answer+=i;
    	return answer;
	}
	
	public static void main(String[] args) {
		Sum_TwoNums s = new Sum_TwoNums();
		System.out.println(s.solution(5, 3));
	}
}


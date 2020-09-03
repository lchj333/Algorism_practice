package webTest;

public class Sum_TwoNums {
	//두 정수의 합 ex)3~5 = 12
	public long solution(int a, int b) {
		long answer = 0;
        if(a-b<0) for(int i=a; i<=b; i++) answer+=i;
    	else for(int i=b; i<=a; i++) answer+=i;
    	return answer;
	}
	
	public static void main(String[] args) {
		Sum_TwoNums s = new Sum_TwoNums();
		System.out.println(s.solution(5, 3));
	}
}

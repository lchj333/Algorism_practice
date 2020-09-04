package test;

public class Averege {
	public double solution(int[] arr) {
        double answer = 0;
        for(int i : arr) answer += i;
        return answer/arr.length;
    }
	
	public static void main(String[] args) {
		Averege a = new Averege();
		System.out.println(a.solution(new int[]{1,2,3}));
	}
}

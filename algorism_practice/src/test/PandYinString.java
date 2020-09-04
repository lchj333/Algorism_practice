package test;

public class PandYinString {
	//문자열 내에 'p'와 'y'의 개수가 같다면 true
	boolean solution(String s) {
		int p=0, y=0;
		s = s.toUpperCase();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='P') p++;
			else if(s.charAt(i)=='Y') y++;
		}
		return p==y;
    }
	
	public static void main(String[] args) {
		PandYinString py = new PandYinString();
		System.out.println(py.solution("py"));
	}
}

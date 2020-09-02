package test;

public class Middle_Char {
	/*
	 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
	 * 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
	 * 
	 * 제한사항
	 * s는 길이가 1 이상, 100이하인 스트링입니다.
	 */
	public String solution(String s) {
        char[] c = s.toCharArray();
        int i = c.length/2;
        
        if(c.length % 2 == 0) { //짝수
        	return "" + c[i-1] + c[i];
        }else {
        	return "" + c[i];
        }
        
    }
	
	public static void main(String[] args) {
		Middle_Char mc = new Middle_Char();
		System.out.println(mc.solution("qwerty"));
	}

}

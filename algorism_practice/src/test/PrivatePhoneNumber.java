package test;

public class PrivatePhoneNumber {
	public static void main(String[] args) {
		PrivatePhoneNumber al = new PrivatePhoneNumber();
		String answer = al.solution("01033334444");
		System.out.println(answer);
	}
	
	public String solution(String phone_number) {
        String answer = "";
        
        int size = phone_number.length();
        int index = size - 4;
        
        for(int i=0; i<index; i++) {
        	answer+="*";
        }
        answer += phone_number.substring(index);
        
        return answer;
    }

}

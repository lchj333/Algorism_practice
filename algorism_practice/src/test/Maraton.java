package test;

import java.util.Arrays;

public class Maraton {
	static String[] participant = {"mislav", "stanko", "mislav", "ana"};
	static String[] completion = {"stanko", "ana", "mislav"};
	
	public String solution(String[] participant, String[] completion) {
		int i = 0;
		Arrays.sort(participant);
		Arrays.sort(completion);
    	for(String comp : completion) {
    		if(!comp.equals(participant[i])) {
    			return participant[i];
    		}
    		i++;
    	}
        return participant[participant.length-1];
    }
	
	public static void main(String[] args) {
		Maraton m = new Maraton();
		System.out.println(m.solution(participant, completion));
	}
}

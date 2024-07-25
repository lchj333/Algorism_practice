package practice.algorism.programmers.lv1;

import java.util.*;

public class Crain {
	static int[][] board = {{0, 0, 1, 0, 0},
							{0, 0, 1, 0, 0},
							{0, 2, 1, 0, 0},
							{0, 2, 1, 0, 0},
							{0, 2, 1, 0, 0}};
	static int[] moves = {1, 2, 3, 3, 2, 3, 1};
	
	public int solution1(int[][] board, int[] moves) {
		int temp = 0;//이전에 뽑은 인형
		int count = 0;//터뜨려진 인형 카운트
		
        for(int m : moves) {
        	for(int i=0; i<board.length; i++) {
        		int doll = board[i][m-1];
        		System.out.println("doll = "+doll);
	    		if(doll != 0) {
	    			System.out.println("board[i][m-1] = "+board[i][m-1]);
	    			board[i][m-1] = 0;
	    			if(temp!=0 && temp==doll) {
	    				count=count+2;
	    				System.out.println("[m] = "+(m-1)+","+"count = "+count);
	    			}
	    			temp = doll;
	    			break;
	    		}
        	}
    	}
        return count;
        /*	
         * 	실패사유: 리스트 안쓰고 하려했지만
         *  인형을 터뜨린 후 그아래에 있는 인형과
         *  종류가 같아 연속으로 터질 수 있기때문에
         *  저장을 해두어야 함
         */
    }
	
	public int solution2(int[][] board, int[] moves) {
		LinkedList<Integer> bucket = new LinkedList<Integer>();
		int count = 0;
        for(int m : moves) {
        	int last = bucket.size()-1;
        	for(int i=0; i<board.length; i++) {
        		int doll = board[i][m-1];
        		
	    		if(doll != 0) {
	    			board[i][m-1] = 0;
	    			if(!bucket.isEmpty() && bucket.get(last)==doll) {
	    				count+=2;
	    				bucket.remove(last);
	    				break;
	    			}
	    			bucket.add(doll);
	    			break;
	    		}
        	}
    	}
        return count;
	}
	
	public static void main(String[] args) {
		Crain c = new Crain();
		System.out.println(c.solution2(board, moves));
	}
}
/*
크레인 인형뽑기 게임
https://school.programmers.co.kr/learn/courses/30/lessons/64061
*/

import java.util.*;

class Solution {
    static final int CHAR_TO_INT = 48;
    
    public String solution(String X, String Y) {
        String answer = "";
        
        int[] arrayX = getNumCntArray(X.toCharArray());
        int[] arrayY = getNumCntArray(Y.toCharArray());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i > -1; i--) {
            while(arrayX[i]-- > 0 && arrayY[i]-- > 0) {
                sb.append(i);
            }
        }
        
        if(sb.length() < 1) {
            return "-1";
        }else if(sb.charAt(0) == '0') {
            return "0";
        }else {
            return sb.toString();    
        }
    }
    
    public int[] getNumCntArray(char[] charArray) {
        int[] numCntArray = new int[10];
        
        for(int i = 0; i < charArray.length; i++) {
            numCntArray[charArray[i] - CHAR_TO_INT]++;
        }
        
        return numCntArray;
    }
}
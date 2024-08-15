import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        
        // compareTo를 위해 문자열로 변경
        String[] temp = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        // 정렬 (내림차순)
        Arrays.sort(temp, (o1, o2) -> {
            return compareArray(o1, o2);
        });

        // 정렬된 배열 결과 출력
        StringBuilder sb = new StringBuilder();
        for (String s : temp) {
            //System.out.println(s);

            //입력값 {0, 0...} 악질 케이스 분기처리
            if(sb.length() == 0 && s.compareTo("0") == 0) {
                continue;
            }
            
            sb.append(s);
        }
        
        if(sb.length() == 0) {
            sb.append("0");
        }

        return sb.toString();
    }
    
    public static int compareArray(String o1, String o2) {
        int minLen = Math.min(o1.length(), o2.length());
        for(int i = 0; i < minLen; i++) {

            int comp = o1.substring(i, i+1).compareTo(o2.substring(i, i+1));
            //System.out.println(o1 + "["+o1.substring(i, i+1)+"], " + o2 + "["+o2.substring(i, i+1)+"], comp : " + (comp * -1));

            if(comp == 0) { // 비교값 같음

                if(i + 2 > o1.length()) {
                    if(i + 2 > o2.length()) {
                        // 길이 같음
                        //System.out.println("i + 2 : " + (i + 2) + ", o1.length() : " + o1.length() + ", o2.length() : " + o2.length());
                        return 0;
                    }else {
                        // o1의 길이가 더 짧음 ex) 11 110 일 때, 11 과  11을 자른 0 을 다시 비교
                        //System.out.println("compareArray("+o1+", "+o2.substring(i+1)+")");
                        return compareArray(o1, o2.substring(i+1));
                    }
                }

                if(i + 2 > o2.length()) {
                    if(i + 2 > o1.length()) {
                        // 길이 같음
                        //System.out.println("i + 2 : " + (i + 2) + ", o1.length() : " + o1.length() + ", o2.length() : " + o2.length());
                        return 0;
                    }else {
                        // o2의 길이가 더 짧음
                        //System.out.println("compareArray("+o1.substring(i+1)+", "+o2+")");
                        return compareArray(o1.substring(i+1), o2);
                    }
                }

            }else { // o1이 더 크거나 또는 o2가 더 큼
                return comp * -1; // 내림차순 정렬
            }
        }// for end
        // 길이, 문자 같음
        return 0;
    }
}
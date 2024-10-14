import java.util .*;

class Solution {
    
    public String solution(String number, int k) {
        
        String[] array = new String[number.length()];
        int arrayIdx = 0;
        int numberIdx = 0;

        for (; numberIdx < number.length(); numberIdx++) {
            String temp = number.substring(numberIdx, numberIdx + 1);

            if(k == 0) {
                array[arrayIdx++] = number.substring(numberIdx);
                break;

            }else {
                if(arrayIdx > 0) {
                    if(array[arrayIdx-1].compareTo(temp) < 0) {
                        // array[arrayIdx]가 더 작으면...

                        int max = arrayIdx;
                        for(int i = 1; i <= max; i++) {
                            // 앞에 연속으로 작은 수 존재 케이스 제거
                            if(arrayIdx-1 > -1 && k > 0 && array[arrayIdx-1].compareTo(temp) < 0) {
                                //System.out.println("array[" + (arrayIdx-1) + "] change null");
                                array[--arrayIdx] = null;
                                k--;
                            }else {
                                break;
                            }
                        }

                        //System.out.println("array[" + arrayIdx + "] change " + temp);
                    }else {
                        //System.out.println("array[" + arrayIdx + "] add " + temp);
                    }
                }else {
                    //System.out.println("array[" + arrayIdx + "] add " + temp);
                }
                
                // 숫차 추가
                array[arrayIdx++] = temp;
            }
        }

        // 남았으면 마지막 숫자부터 제거
        if(k > 0) {
            String temp = array[arrayIdx - 1];
            array[arrayIdx - 1] = temp.substring(0, temp.length() - k);
        }

        // 결과 도출
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arrayIdx; i++) {
            sb.append(array[i]);
        }

        return sb.toString();
    }
    
    
}
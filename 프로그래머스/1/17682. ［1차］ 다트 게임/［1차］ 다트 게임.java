class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] dart = dartResult.toCharArray();
        int nowScore = 0;
        int prevScore = 0;

        int i = 0;
        while(i < dart.length) {

            if('0' <= dart[i] && dart[i] <= '9' ) {
                // 점수 체크
                if(dart[i] == '1' && dart[i + 1] == '0') {
                    nowScore = Integer.parseInt(""+ dart[i] + dart[++i]);

                }else {
                    nowScore = Integer.parseInt(""+ dart[i]);
                }

            } else {
                // 제곱 체크
                int exp = switch (dart[i++]) {
                    case 'S' -> 1;
                    case 'D' -> 2;
                    case 'T' -> 3;
                    default -> 0;
                };
                System.out.print(", exp : " + exp);

                // 제곱 계산.
                int temp = nowScore;
                for(; exp > 1; exp--) {
                    temp *= nowScore;
                }
                nowScore = temp;

                // 옵션 체크
                if(i < dart.length) {
                    // 옵션 점수 계산
                    switch (dart[i]) {
                        case '*': // 스타상
                            nowScore *= 2;
                            break;
                        case '#': // 아차상
                            nowScore *= -1;
                            prevScore = 0;
                            break;
                        default: // 옵션 없음
                            prevScore = 0;
                            i--; // no option -> 이미 증감된값 원위치
                    }
                    
                    answer += prevScore + nowScore;
                    prevScore = nowScore;

                }else { // 옵션 무조건 없음
                    // 점수 합산 normal
                    answer += nowScore;
                } // if end (option check)

            } // if end (char check)

            i++;
        } // while end

        return answer;
    }
}
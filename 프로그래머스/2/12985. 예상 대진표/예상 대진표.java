class Solution {
    public int solution(int n, int a, int b) {
        int round = 1;

        int A = Math.min(a, b); // 너 A
        int B = Math.max(a, b); // 너 B (아니)

        // A와 B가 무조건 만나므로 무한루프 없음.
        while( true ) {

            boolean isBEvenNum = B % 2 == 0 ? true : false;

            // B가 A의 우측 상대일 때 리턴
            if(isBEvenNum && B - A == 1)
                return round;
            
            ++round;

            // A가 승리하여 라운드 진출 (ex: 1라운드 > 3또는4, 2라운드 > 2) && 진출 재배정 번호 계산
            if(A % 2 == 1)
                ++A; // 짝수 만들기
            A = A / 2;

            // B가 승리하여 라운드 진출 (ex: 1라운드 > 3또는4, 2라운드 > 2) && 진출 재배정 번호 계산
            if( ! isBEvenNum )
                ++B; // 짝수 만들기
            B = B / 2;
        }
    }

}
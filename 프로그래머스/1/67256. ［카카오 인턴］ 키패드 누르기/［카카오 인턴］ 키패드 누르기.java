class Solution {
    

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        boolean isRight = true;
        if("left".equals(hand)) isRight = false;

        Thumb right = new Thumb(3,2);
        Thumb left = new Thumb(3, 0);

        for(int num : numbers) {
            if(num == 0) num = 11;

            int y = (num - 1) / 3;
            int x = num % 3 - 1;
            if(x == -1) x = 2;

            int rd = right.getDistance(y, x);
            int ld = left.getDistance(y, x);

            if(x == 1) {
                if(rd < ld) { // 오른쪽이 더 가까움
                    answer.append("R");
                    right.setPoint(y, x);

                }else if(ld == rd) { // 거리 동일.
                    if(isRight) {
                        answer.append("R");
                        right.setPoint(y, x);
                    }else {
                        answer.append("L");
                        left.setPoint(y, x);
                    }

                }else { // 왼쪽이 더 가까움
                    answer.append("L");
                    left.setPoint(y, x);
                }

            }else {
                if(x == 0) { // 왼쪽 패드
                    answer.append("L");
                    left.setPoint(y, x);

                }else { // 오른쪽 패드
                    answer.append("R");
                    right.setPoint(y, x);
                }
            }
        }

        return answer.toString();
    }
    
    class Thumb {
        int y, x;

        Thumb(int y, int x) {
            setPoint(y, x);
        }

        public void setPoint(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getDistance(int y, int x) {
            return removeMinus(this.y - y) + removeMinus(this.x - x);
        }

        private int removeMinus(int temp) {
            if(temp < 0)
                return temp * -1;
            else
                return temp;
        }

    }
}
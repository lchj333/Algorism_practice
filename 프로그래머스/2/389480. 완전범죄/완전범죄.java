import java.util.*;

class Solution {
    
    private Stack<Evidence> mainStack = new Stack<>(); // 데이터 읽기
    private Stack<Evidence> subStack = new Stack<>(); // 데이터 저장
    
    public int solution(int[][] info, int n, int m) {
        // 초기 세팅
        mainStack.push(new Evidence(0, 0));

        // B오름차순, A오름차순 정렬
        Arrays.sort(info, ((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }else {
                return o1[1] - o2[1];
            }
        }));

        // 흔적 정보들을 순차적으로 순회
        for(int[] footPrint : info) {

            while(! mainStack.isEmpty()) {

                // 연산을 위해 데이터 GET
                Evidence evidence = mainStack.pop();

                // B 흔적 초과 계산 & 적재
                if(m > evidence.B + footPrint[1]) {
                    addStack(subStack, new Evidence(evidence.A, evidence.B + footPrint[1]));
                }

                // A 흔적 초과 계산 & 적재
                if(n > evidence.A + footPrint[0]) {
                    addStack(subStack, new Evidence(evidence.A + footPrint[0], evidence.B));
                }
            }

            // 데이터 위치 교체
            mainStack = subStack;
            subStack = new Stack<>();
        }

        // A의 최소 흔적 계산
        if(mainStack.isEmpty()) {
            return -1;
        }else {
            int minA = Integer.MAX_VALUE;
            while(! mainStack.isEmpty()) {
                int tempA = mainStack.pop().A;
                if(minA > tempA) {
                    minA = tempA;
                }
            }
            return minA;
        }
    }

    // 같은값 유무 확인 후 적재
    public void addStack(Stack<Evidence> stack, Evidence evidence) {
        if(! stack.contains(evidence)) {
            stack.push(evidence);
        }
    }

    class Evidence {
        int A = 0;
        int B = 0;

        public Evidence(int a, int b) {
            A = a;
            B = b;
        }

        @Override
        public String toString() {
            return "{A=" + A + ", B=" + B + '}';
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Evidence) {
                Evidence evidence = (Evidence) obj;
                return A == evidence.A && B == evidence.B;
            }

            return false;
        }

    }
    
}
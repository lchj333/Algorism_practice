import java.util.*;

class Solution {
    
    public int solution(int n, int[][] costs) {
        // 크루스칼 알고리즘 이용 (https://chanhuiseok.github.io/posts/algo-33/)
        int answer = 0;

        // 가중치 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        /*
        for(int[] info : costs)
            System.out.println(info[0] + " " + info[1] + " " + info[2]);
        */

        // 부모는 자기자신으로 초기화
        int[] parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        // 가중치 오름차순 정렬된 리스트 순회
        for(int[] info : costs) {

            // 서로 부모가 다른경우 = 연결되어있지 않은 상태
            if(parents[info[0]] != parents[info[1]]) {
                // 그렇다면 연결 (연결되었다 == 같은 부모를 가지고 있다.)

                // 연결되었을 때 가중치 계산
                answer += info[2];

                // 한쪽 부모로 합치기
                int oldParent = parents[info[1]];
                int newParent = parents[info[0]];
                for(int i = 0; i < parents.length; i++) {
                    // 부모가 변경되므로 같은곳을 바라보고 있는 자식들도 변경
                    if(parents[i] == oldParent) {
                        //System.out.println("parents[" + i +"] => " + parents[i] + " ==> " + newParent);
                        parents[i] = newParent;
                    }
                }

            }
            /*
            for(int i=0; i < n; i++) {
                System.out.print("[" + i + ", parent = " + parents[i] + "] ");
            }
            System.out.println();
            */
        }
        
        return answer;
    }
}
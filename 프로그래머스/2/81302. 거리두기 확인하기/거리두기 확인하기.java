class Solution {
    final int[][] dist = new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int answerIdx = 0;
        
        for(String[] place : places) {
            char[][] chars = new char[place.length][];
            for(int i = 0; i < place.length; i++) {
                chars[i] = place[i].toCharArray();
            }
            
            boolean isKeepRule = true;
            
            checkRuleBeginFor:
            for(int y = 0; y < chars.length; y++) {
                for(int x = 0; x < chars[y].length; x++) {
                    // 현재칸이 응시자가 아니면 주변 칸 볼 필요 없음.
                    if(chars[y][x] != 'P') continue;
                    
                    // 상하좌우 한칸거리에서 부터 판별 시작
                    for(int[] d1 : dist) {
                        int d1y = y + d1[1];
                        int d1x = x + d1[0];
                        if(chkInsideIdx(d1y, d1x, 5)) {
                            // 여기에 다른 응시자 있으면 실패
                            if(chars[d1y][d1x] == 'P') {
                                isKeepRule = false;
                                break checkRuleBeginFor;
                                
                            }else if(chars[d1y][d1x] == 'O') {
                                // 테이블이면 2칸 거리 판단
                                for(int[] d2 : dist) {
                                    int d2y = d1y + d2[1];
                                    int d2x = d1x + d2[0];
                                    
                                    if((d2y != y | d2x != x) && chkInsideIdx(d2y, d2x, 5)) {
                                        // 2칸: 빈 테이블, 파티션 => 사람 없으면 괜찮다.
                                        // 2칸: 다른 응시자 있으면 검거
                                        if(chars[d2y][d2x] == 'P') {
                                            isKeepRule = false;
                                            break checkRuleBeginFor;
                                        }
                                    } // chk distance 2 index end
                                } // distance 2 for end
                            } // if distance 1 end
                        } // chk distance 1 index end
                    } // distance 1 for end
                } // x for end
            } // y for end
            
            // 규칙 준수 여부 판단
            if(isKeepRule) {
                answer[answerIdx] = 1;
            }else {
                answer[answerIdx] = 0;
            }
            answerIdx++;
        }
        
        return answer;
    }
    
    public boolean chkInsideIdx(int dy, int dx, int max) {
        return -1 < dy && dy < max && -1 < dx && dx < max;
    }
}
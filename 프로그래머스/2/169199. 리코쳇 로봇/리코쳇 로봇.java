import java.util.*;

class Solution {
    // 상하좌우
    final static int[] dy = new int[]{1, -1, 0, 0};
    final static int[] dx = new int[]{0, 0, -1, 1};

    final static char start = 'R';
    final static char goal = 'G';
    final static char block = 'D';
    final static char blank = '.';

    public int solution(String[] board) {
        // char array 변환
        char[][] charBoard = new char[board.length][];
        for (int y = 0; y < board.length; y++) {
            charBoard[y] = board[y].toCharArray();
        }

        // 골, 스타트 위치는??
        Place startPlace = null;
        Place goalPlace = null;
        for (int y = 0; y < charBoard.length; y++) {
            for (int x = 0; x < charBoard[y].length; x++) {
                if (charBoard[y][x] == goal) {
                    goalPlace = new Place(y, x, 0);
                } else if (charBoard[y][x] == start) {
                    startPlace = new Place(y, x, 0);
                }
            }
        }

        // 도달 가능한가? 1차 검증
        if (!isPossibleToGoal(charBoard, goalPlace.y, goalPlace.x)) {
            return -1;
        }

        // 멈춤 구간 체크용
        int[][] minMoveStopedInfo = new int[charBoard.length][charBoard[0].length];

        // 작업 스택 생성
        CustomStack<Place> myStack = new CustomStack<>();
        myStack.push(startPlace);

        while(! myStack.isEmpty()) {
            Place now = myStack.pop();
            for(int i = 0; i < 4; i++) { // 4방향으로
                int nowY = now.y;
                int nowX = now.x;
                int nextMoveCnt = now.moveCnt+1;

                while (true) { // 미끄러지기~
                    nowY += dy[i];
                    nowX += dx[i];
                    if (nowY >= charBoard.length || 0 > nowY || nowX >= charBoard[nowY].length || 0 > nowX || charBoard[nowY][nowX] == block) {
                        nowY -= dy[i];
                        nowX -= dx[i];
                        break;
                    }
                }

                if(minMoveStopedInfo[nowY][nowX] == 0 || minMoveStopedInfo[nowY][nowX] > nextMoveCnt) {
                    minMoveStopedInfo[nowY][nowX] = nextMoveCnt;
                    myStack.pushToOtherStack(new Place(nowY, nowX, nextMoveCnt));
                }
            }
        }

        int answer = minMoveStopedInfo[goalPlace.y][goalPlace.x];
        return answer == 0 ? -1 : answer;
    }

    public boolean isPossibleToGoal(char[][] board, int y, int x) {
        for (int dIdx = 0; dIdx < 4; dIdx++) {
            if (isArrivedEndPoint(board, y, x)) {
                return true;
            } else if (board[y + dy[dIdx]][x + dx[dIdx]] == block) {
                return true;
            }
        }
        return false;
    }

    public boolean isArrivedEndPoint(char[][] board, int y, int x) {
        return y == 0 || y == board.length - 1 || x == 0 || x == board[y].length - 1;
    }
}

class Place {
    int y;
    int x;
    int moveCnt;
    public Place(int ty, int tx, int tMoveCnt) {
        y = ty;
        x = tx;
        moveCnt = tMoveCnt;
    }
}

class CustomStack <T> {
    boolean isUseFirstStack = true;
    Stack<T> firstStack = new Stack<>();
    Stack<T> secondStack = new Stack<>();

    private void switchStack() {
        isUseFirstStack = ! isUseFirstStack;
    }

    public boolean isEmpty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }

    public T pop() {
        if(isUseFirstStack) {
            if(! firstStack.isEmpty()) {
                return firstStack.pop();
            }else {
                switchStack();
                return secondStack.pop();
            }
        }else {
            if(! secondStack.isEmpty()) {
                return secondStack.pop();
            }else {
                switchStack();
                return firstStack.pop();
            }
        }
    }

    public void push(T obj) {
        if(isUseFirstStack) {
            firstStack.push(obj);
        }else {
            secondStack.push(obj);
        }
    }

    public void pushToOtherStack(T obj) {
        if(isUseFirstStack) {
            secondStack.push(obj);
        }else {
            firstStack.push(obj);
        }
    }
}

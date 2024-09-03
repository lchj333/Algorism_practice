import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack;

        for(int i = 0; i < s.length()-1; i++) {
            String brackets = new StringBuilder().append(s.substring(i)).append(s.substring(0, i)).toString();
            stack = new Stack();

            for(int b = 0; b < brackets.length(); b++) {
                char c = brackets.charAt(b);

                if(isOpenBracket(c))
                    stack.push(c);
                else if(stack.isEmpty()) {
                    stack.push(c);
                    break;
                }else {
                    if(stack.peek() == '(' && c == ')') {
                        stack.pop();
                    }else if(stack.peek() == '{' && c == '}') {
                        stack.pop();
                    }else if(stack.peek() == '[' && c == ']') {
                        stack.pop();
                    }else {
                        break;
                    }
                }
            }

            if(stack.isEmpty())
                answer++;
        }

        return answer;
    }

    private boolean isOpenBracket(char bracket) {
        switch (bracket) {
            case '(': case '{': case '[':
                return true;
            default:
                return false;
        }
    }
}
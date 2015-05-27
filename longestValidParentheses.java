public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        char[] ch = s.toCharArray();
        int left = -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '(') {
                stack.push(i);
            }else {
                if(stack.isEmpty()) {
                    left = i;
                }else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        int newLen = i - left;
                        if(newLen > max) max = newLen;
                    }else {
                        int newLen = i - stack.peek();
                        if(newLen > max) max = newLen;
                    }
                }
            }
        }
        return max;
    }
}
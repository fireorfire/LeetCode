public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        for(int i = 0; i <= height.length; i++) {
            int h = (i == height.length)?0:height[i];
            if(stack.isEmpty() || height[stack.peek()] <= h) {
                stack.push(i);
            }else {
                int top = stack.pop();
                int tem = height[top] * ((stack.isEmpty())?(i):(i - stack.peek() - 1));
                if(tem > max) max = tem;
                i--;
            }
        }
        return max;
    }
}
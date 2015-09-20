public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parr = path.split("/");
        for(int i = 0; i < parr.length; i++) {
            if(parr[i].length() == 0 || parr[i].equals(".")) continue;
            if(parr[i].equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(parr[i]);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) sb.insert(0, "/");
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}
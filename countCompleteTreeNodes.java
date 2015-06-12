/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = checkLeftHeight(root.left);
        int rh = checkLeftHeight(root.right);
        if(lh == rh) {
            if(lh == 0) return 1;
            return (int)Math.pow(2, lh) + countNodes(root.right) ;
        }else return countNodes(root.left) + (int)Math.pow(2, rh) ;
    }
    public int checkLeftHeight(TreeNode root) {
        int count = 0;
        while(root != null) {
            root = root.left;
            count++;
        }
        return count;
    }
    
}
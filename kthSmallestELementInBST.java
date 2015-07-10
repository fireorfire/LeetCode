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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) throw new IllegalArgumentException("empty tree");
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            count++;
            if(count == k) return node.val;
            if(node.right != null) {
                node = node.right;
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        throw new IllegalArgumentException("excess the limit");
    }
}
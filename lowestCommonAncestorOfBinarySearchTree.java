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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q) return p;
        if(p.val > q.val) {
            TreeNode tem = p;
            p = q;
            q = tem;
        }
        while(true) {
            if(root.val > q.val) root = root.left;
            else if(root.val < p.val) root = root.right;
            else break;
        }
        return root;
    }
}
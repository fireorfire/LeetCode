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
    private TreeNode result = null, q, p;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q) return p;
        this.q = q;
        this.p = p;
        checkLCA(root);
        return result;
    }
    public boolean checkLCA(TreeNode root) {
        if(root == null) return false;
        if(root == q || root == p) {
            if(checkLCA(root.left) || checkLCA(root.right)) {
                result = root;
            }
            return true;
        }else {
            boolean lb = checkLCA(root.left);
            if(result != null) return true;
            boolean rb = checkLCA(root.right);
            if(lb && rb) result = root;
            return lb || rb;
        }
    }
}
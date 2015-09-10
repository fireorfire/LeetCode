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
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            traverseTreeNode(root, new StringBuilder());
        }
        return result;
    }
    public void traverseTreeNode(TreeNode root, StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder(stringBuilder);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        }
        if (root.left != null) {
            sb.append("->");
            traverseTreeNode(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            sb.append("->");
            traverseTreeNode(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
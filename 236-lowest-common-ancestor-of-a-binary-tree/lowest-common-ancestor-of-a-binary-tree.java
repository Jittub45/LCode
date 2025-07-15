/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode r, TreeNode p, TreeNode q) {
        if (r == null || r == p || r == q) return r;
        TreeNode l = lowestCommonAncestor(r.left, p, q);
        TreeNode ri = lowestCommonAncestor(r.right, p, q);
        if (l != null && ri != null) return r;
        return l != null ? l : ri;
    }
}

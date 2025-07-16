/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        int ans = checkH(root);
        if(ans == -1){
            return false;
        }else{
            return true;
        }
        
    }
    private int checkH(TreeNode root){
        if(root == null){
            return 0;
        }
        int lH = checkH(root.left);
        if (lH == -1) return -1;
        int rH = checkH(root.right);
        if (rH == -1) return -1;
        if (Math.abs(lH - rH) > 1) return -1;

        return Math.max(lH, rH) + 1;
    }
}
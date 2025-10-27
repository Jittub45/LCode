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

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return res;
    }
    private int solve(TreeNode node){

        if(node == null)return 0;

        int leftTree = solve(node.left);
        int rightTree = solve(node.right);

        int temp = Math.max(node.val, node.val + Math.max(leftTree, rightTree));
        int ans = Math.max((leftTree + rightTree) + node.val, temp);
        
        res = Math.max(res, ans);

        return temp;
    }
}
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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        solve(root, res, 0);        
        return res;
    }
    public void solve(TreeNode root, List<Integer> res, int lev){
        if(root == null) return;

        if(lev == res.size()){
            res.add(root.val);
        }
        solve(root.right, res, lev + 1);
        solve(root.left, res, lev + 1);
    }
}
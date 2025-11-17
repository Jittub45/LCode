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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        
        if(root == null) return res;

        queue.offer(root);
        while(!queue.isEmpty()){
            int qsize = queue.size();

            List<Integer> currLevEle = new ArrayList<>();
            for(int i = 0; i < qsize; i++){
                TreeNode currEle = queue.poll();
                currLevEle.add(currEle.val);

                if(currEle.left != null){
                    queue.offer(currEle.left);
                }
                if(currEle.right != null){
                    queue.offer(currEle.right);
                }
            }
            res.add(currLevEle);
        }
        return res;        
    }
}
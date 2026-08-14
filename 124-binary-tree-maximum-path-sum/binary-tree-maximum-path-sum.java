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
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxi;
    }
    int maxi=Integer.MIN_VALUE;
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);

        int max=root.val;
        max=Math.max(root.val+left,max);
        max=Math.max(root.val+right,max);
        maxi=Math.max(root.val+left+right,maxi);

        maxi=Math.max(maxi,max);

        return max;


    }
}

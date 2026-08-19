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
    public int maxProduct(TreeNode root) {
        totalSum=sumSubtree(root);
        maxProd=0;

        maxProductSubtree(root);

        return (int)(maxProd%mod);

    }

    public long maxProductSubtree(TreeNode root){
        if(root==null){
            return 0;
        }
        long left=maxProductSubtree(root.left);
        long right=maxProductSubtree(root.right);

        long remLeft=totalSum-left;
        long remRight=totalSum-right;

        maxProd=Math.max(maxProd,left*remLeft);
        maxProd=Math.max(maxProd,right*remRight);

        return left+right+(long)root.val;
    }

    long totalSum;
    long maxProd;
    int mod=1_000_000_007;

    public long sumSubtree(TreeNode root){
        if(root==null){
            return 0;
        }
        long left=sumSubtree(root.left);
        long right=sumSubtree(root.right);

        return (long)root.val+left+right;
    }
}
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
    static int mod=1_000_000_007;
    static long maxProd=0;
    static long totalSum=0;
    public int maxProduct(TreeNode root) {
        maxProd=0;
        totalSum=treeSum(root);
        long s1=subTreeSum(root);
        return (int)(maxProd%mod);
    }
    public static long subTreeSum(TreeNode root){
        if(root==null){
            return 0;
        }
        long left=subTreeSum(root.left);
        long right=subTreeSum(root.right);
        long s1=left+right+root.val;
        long s2=totalSum-s1;
        maxProd=Math.max(maxProd,s1*s2);
        return s1;
    }
    public static long treeSum(TreeNode root){
        if(root==null){
            return 0;
        }
        long leftSum=treeSum(root.left);
        long rightSum=treeSum(root.right);
        long sum=leftSum+rightSum+root.val;
        return sum;
    }
}
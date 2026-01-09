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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth=findMaxDepth(root);
        return findNode(root,0,maxDepth-1);
    }
    public static TreeNode findNode(TreeNode node,int depth,int maxDepth){
        if(node==null){
            return null;
        }
        if(depth==maxDepth){
            return node;
        }
        TreeNode left=findNode(node.left,depth+1,maxDepth);
        TreeNode right=findNode(node.right,depth+1,maxDepth);
        if(left!=null && right!=null){
            return node;
        }
        return (left!=null)?left:right;        
    }
    public static int findMaxDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=findMaxDepth(node.left);
        int right=findMaxDepth(node.right);
        return Math.max(left,right)+1;
    }
}
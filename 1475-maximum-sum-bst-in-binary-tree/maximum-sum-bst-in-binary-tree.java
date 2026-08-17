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
    public int maxSumBST(TreeNode root) {
        maxBST=0;
        Pair temp=DFS(root);
        return maxBST;
    }
    int maxBST;

    public Pair DFS(TreeNode root){
        if(root==null){
            return new Pair(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        Pair left=DFS(root.left);
        Pair right=DFS(root.right);

        if(left.isBST && right.isBST && root.val>left.max && root.val<right.min){
            int sum=left.sum+right.sum+root.val;
            maxBST=Math.max(maxBST,sum);
            int min=Math.min(root.val,left.min);
            int max=Math.max(root.val,right.max);
            return new Pair(true,sum,min,max);
        }
        return new Pair(false,Integer.MIN_VALUE,-1,-1);
    }

    public class Pair{
        boolean isBST;
        int sum;
        int min;
        int max;

        Pair(boolean isBST,int sum,int min,int max){
            this.isBST=isBST;
            this.sum=sum;
            this.min=min;
            this.max=max;
        }

    }
}
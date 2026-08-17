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
        int [] temp=DFS(root);
        return maxBST;
    }
    int maxBST;

    public int[] DFS(TreeNode root){
        if(root==null){
            return new int[]{1,0,Integer.MAX_VALUE,Integer.MIN_VALUE};
        }

        int [] left=DFS(root.left);
        int [] right=DFS(root.right);

        if(left[0]==1 && right[0]==1 && root.val>left[3] && root.val<right[2]){
            int sum=left[1]+right[1]+root.val;
            maxBST=Math.max(maxBST,sum);
            int min=Math.min(root.val,left[2]);
            int max=Math.max(root.val,right[3]);
            return new int[]{1,sum,min,max};
        }
        return new int[]{0,Integer.MIN_VALUE,-1,-1};
    }

    // public class Pair{
    //     boolean isBST;
    //     int sum;
    //     int min;
    //     int max;

    //     Pair(boolean isBST,int sum,int min,int max){
    //         this.isBST=isBST;
    //         this.sum=sum;
    //         this.min=min;
    //         this.max=max;
    //     }

    // }
}
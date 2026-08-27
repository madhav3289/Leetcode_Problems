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
    public int rob(TreeNode root) {
        int [] val=DFS(root);
        return Math.max(val[0],val[1]);
    }

    public int[] DFS(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }

        int [] left=DFS(root.left);

        int [] right=DFS(root.right);

        int inc=root.val+left[1]+right[1];
        int exc=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{inc,exc};
    }
}
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return DFS1(root,subRoot);
    }
    public boolean DFS1(TreeNode root,TreeNode subRoot){
        if(root==null){
            return false;
        }

        if(root.val==subRoot.val){
            if(checkSubTree(root,subRoot)){
                return true;
            }
        }

        boolean left=DFS1(root.left,subRoot);
        boolean right=DFS1(root.right,subRoot);

        return left || right;
    }
    public boolean checkSubTree(TreeNode root,TreeNode subroot){
        if(root==null && subroot==null){
            return true;
        }
        if(root==null || subroot==null){
            return false;
        }
        if(root.val!=subroot.val){
            return false;
        }

        boolean left=checkSubTree(root.left,subroot.left);
        boolean right=checkSubTree(root.right,subroot.right);

        return left && right;
    }
}
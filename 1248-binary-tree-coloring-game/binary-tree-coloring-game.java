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

    TreeNode xNode;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        xNode=null;

        // find the node x
        findNode(root,x);

        // calculate total number of nodes left subtree and right subtree of x

        // left child
        int left=calcTotalNodes(xNode.left);
        // right child
        int right=calcTotalNodes(xNode.right);

        // parent 
        int parent=n-(left+right+1);

        int maxi=Math.max(parent,Math.max(left,right));
        
        return maxi>n-maxi;
    }

    public int calcTotalNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        return calcTotalNodes(root.left)+calcTotalNodes(root.right)+1;
    }

    public void findNode(TreeNode root,int x){
        if(root==null){
            return;
        }
        if(root.val==x){
            xNode=root;
            return;
        }
        findNode(root.left,x);
        findNode(root.right,x);
    }
}
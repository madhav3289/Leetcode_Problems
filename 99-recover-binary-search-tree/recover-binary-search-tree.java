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

    // Method 2 >> Optimal >> TC : O(n) , SC : O(1)

    public void recoverTree(TreeNode root) {
        prev=null;
        first=null;
        second=null;

        inorderTraversal(root);

        // swap
        int temp=first.val;
        first.val=second.val;
        second.val=temp;

    }
    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null){
                first=prev;
            }
            second=root;
        }
        prev=root;
        inorderTraversal(root.right);
    }

    // Method 1 >> Using inorderTraversal >> TC : O(nlogn) , SC : O(n)

    // public void recoverTree(TreeNode root) {
    //     inorder=new ArrayList<>();
    //     inorderTraversal(root);

    //     List<Integer> ideal=new ArrayList<>();
    //     for(TreeNode node:inorder){
    //         ideal.add(node.val);
    //     }

    //     Collections.sort(ideal);

    //     for(int i=0;i<ideal.size();i++){
    //         inorder.get(i).val=ideal.get(i);
    //     }

    // }
    // List<TreeNode> inorder;

    // public void inorderTraversal(TreeNode root){
    //     if(root==null){
    //         return;
    //     }

    //     // left
    //     inorderTraversal(root.left);

    //     // root
    //     inorder.add(root);

    //     // right
    //     inorderTraversal(root.right);
    // }
}
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
    List<TreeNode> prefix;
    public TreeNode bstToGst(TreeNode root) {
        prefix=new ArrayList<>();
        
        buildArray(root);

        int n=prefix.size();

        int sum=prefix.get(n-1).val;

        for(int i=n-2;i>=0;i--){
            TreeNode temp=prefix.get(i);
            temp.val+=sum;

            sum=temp.val;
        }

        return root;
    }
    public void buildArray(TreeNode root){
        if(root==null){
            return;
        }

        buildArray(root.left);

        prefix.add(root);

        buildArray(root.right);
    }    
}
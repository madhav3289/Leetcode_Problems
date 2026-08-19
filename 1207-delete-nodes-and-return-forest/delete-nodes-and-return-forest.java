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
    List<TreeNode> result;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set=new HashSet<>();
        for(int num:to_delete){
            set.add(num);
        }

        result=new ArrayList<>();
        int temp=DFS(root,set);
        if(temp!=-1){
            result.add(root);
        }
        return result;
    }
    public int DFS(TreeNode root,Set<Integer> set){
        if(root==null){
            return 0;
        }
        int left=DFS(root.left,set);
        int right=DFS(root.right,set);

        if(set.contains(root.val)){
            if(root.left!=null && left!=-1){
                result.add(root.left);
                root.left=null;
            }
            if(root.right!=null && right!=-1){
                result.add(root.right);
                root.right=null;
            }
            return -1;
        }
        if(left==-1){
            root.left=null;
        }
        if(right==-1){
            root.right=null;
        }
        return 0;
    }
}
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
    public TreeNode recoverFromPreorder(String traversal) {
        N=traversal.length();
        i=0;
        return helper(traversal,0);
    }
    int i;
    int N;

    public TreeNode helper(String s,int depth){
        if(i>=N){
            return null;
        }
        int j=i;
        while(j<N && s.charAt(j)=='-'){
            j++;
        }
        int count=j-i;
        if(count!=depth){
            return null;
        }
        i+=count;
        int num=0;
        while(i<N && s.charAt(i)!='-'){
            num=num*10+(s.charAt(i)-'0');
            i++;
        }
        TreeNode node=new TreeNode(num);
        node.left=helper(s,depth+1);
        node.right=helper(s,depth+1);

        return node;
    }

}
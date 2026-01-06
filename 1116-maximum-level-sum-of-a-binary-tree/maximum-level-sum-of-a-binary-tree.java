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
    public int maxLevelSum(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            // remove
            Pair p=q.poll();
            TreeNode u=p.node;
            int d=p.dist;
            // add neighbours
            if(u.left!=null){
                if(list.size()<=d+1){
                    list.add(u.left.val);
                }
                else{
                    list.set(d+1,list.get(d+1)+u.left.val);
                }
                q.add(new Pair(u.left,d+1));
            }
            if(u.right!=null){
                if(list.size()<=d+1){
                    list.add(u.right.val);
                }
                else{
                    list.set(d+1,list.get(d+1)+u.right.val);
                }
                q.add(new Pair(u.right,d+1));
            }
        }
        int max=0;
        int maxVal=list.get(0);
        for(int i=1;i<list.size();i++){
            if(maxVal<list.get(i)){
                maxVal=list.get(i);
                max=i;
            }
        }
        return max+1;
    }
    static class Pair{
        TreeNode node;
        int dist;
        Pair(TreeNode node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
}
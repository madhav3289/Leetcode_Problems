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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map=new HashMap<>();

        HashSet<Integer> set=new HashSet<>();

        for(int [] temp:descriptions){
            int p=temp[0];
            int c=temp[1];
            int t=temp[2];

            if(!map.containsKey(p)){
                TreeNode node=new TreeNode(p);
                map.put(p,node);
            }

            if(!map.containsKey(c)){
                TreeNode node=new TreeNode(c);
                map.put(c,node);
            }

            // left child
            if(t==1){
                map.get(p).left=map.get(c);
            }

            // right child
            else if(t==0){
                map.get(p).right=map.get(c);
            }

            set.add(c);
        }
        TreeNode root=null;

        for(int key:map.keySet()){
            if(!set.contains(key)){
                root=map.get(key);
            }
        }
        return root;
    }
}
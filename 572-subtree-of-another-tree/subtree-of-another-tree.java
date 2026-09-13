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

    // Optimal Approach -->> TC : O(n + m)   SC: O(n)
    // Using KMP algorithm

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        serialize(root,sb1);
        serialize(subRoot,sb2);

        return KMP(sb1.toString(),sb2.toString());
    }
    public boolean KMP(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int [] lps=longestPrefixSuffix(s2,m);

        int i=0;
        int j=0;
        while(i<n && j<m){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
                if(j==m){
                    return true;
                }
            }
            else{
                if(j==0){
                    i++;
                }
                else{
                    j=lps[j-1];
                }
            }
        }
        return false;
    }
    
    public int[] longestPrefixSuffix(String s,int n){
        int [] lps=new int[n];

        int i=0;
        int j=1;

        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;
            }
            else{
                if(i==0){
                    lps[j]=0;
                    j++;
                }
                else{
                    i=lps[i-1];
                }
            }
        }

        return lps;
    }
    
    public void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }

        sb.append(",").append(root.val).append(",");

        serialize(root.left,sb);
        serialize(root.right,sb);

        return;
    }
}

// Brute Force -->> O(n x m)


// public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//     return DFS1(root,subRoot);
// }
// public boolean DFS1(TreeNode root,TreeNode subRoot){
//     if(root==null){
//         return false;
//     }

//     if(root.val==subRoot.val){
//         if(checkSubTree(root,subRoot)){
//             return true;
//         }
//     }

//     boolean left=DFS1(root.left,subRoot);
//     boolean right=DFS1(root.right,subRoot);

//     return left || right;
// }
// public boolean checkSubTree(TreeNode root,TreeNode subroot){
//     if(root==null && subroot==null){
//         return true;
//     }
//     if(root==null || subroot==null){
//         return false;
//     }
//     if(root.val!=subroot.val){
//         return false;
//     }

//     boolean left=checkSubTree(root.left,subroot.left);
//     boolean right=checkSubTree(root.right,subroot.right);

//     return left && right;
// }
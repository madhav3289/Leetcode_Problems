/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] matrix=new int[m][n];
        for(int [] arr:matrix){
            Arrays.fill(arr,-1);
        }
        int rowSt=0;
        int colSt=0;
        int rowEd=m-1;
        int colEd=n-1;
        while(head!=null){
           
            // right
            for(int i=colSt;i<=colEd && head!=null;i++){
                matrix[rowSt][i]=head.val;
                head=head.next;
            }
            rowSt++;

            // down
            for(int i=rowSt;i<=rowEd && head!=null;i++){
                matrix[i][colEd]=head.val;
                head=head.next;
            }
            colEd--;

            // left
            for(int i=colEd;i>=colSt && head!=null;i--){
                matrix[rowEd][i]=head.val;
                head=head.next;
            }
            rowEd--;

            // up
            for(int i=rowEd;i>=rowSt && head!=null;i--){
                matrix[i][colSt]=head.val;
                head=head.next;
            }
            colSt++;            
        }
        return matrix;
    }
}
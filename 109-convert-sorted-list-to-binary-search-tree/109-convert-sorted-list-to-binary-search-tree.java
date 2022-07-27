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
    ArrayList<Integer> arr;
    public TreeNode sortedListToBST(ListNode head) {
        
        this.arr =convertToArray(head);
        
         return helper(0,arr.size()-1);  
        
    }
    public TreeNode helper(int si,int ei)
    {
        if(si>ei)
            return null;
        
        int mid= (si+ei)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left=helper(si,mid-1);
        root.right=helper(mid+1,ei);
        
        return root;    
    }
    public ArrayList<Integer> convertToArray(ListNode head)
        
    {
        
        ArrayList<Integer> arr = new ArrayList<>();
        while(head!=null)
        {
            arr.add(head.val);
            head=head.next;
        }
        
        return arr;
    }
}
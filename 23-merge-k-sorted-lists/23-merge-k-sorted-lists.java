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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length==0)
            return null;
        int n= lists.length;
        int last=n-1;
        while(last!=0)
        {
            int i=0,j=last;
            while(i<j)
            {
               lists[i] = merge(lists[i],lists[j]);
                i++;
                j--;
                if(i>=j)
                {
                    last=j;
                }
            }
        }
        
        return lists[0];
        
    }
    
    public ListNode merge (ListNode A, ListNode B)
    {
        if(A==null)
            return B;
        
        if(B==null)
            return A;
        
        if(A.val<B.val){
            A.next= merge(A.next,B);
            return A;
        }
         else {
            B.next= merge(A,B.next);
            return B;
        }   
    }
}
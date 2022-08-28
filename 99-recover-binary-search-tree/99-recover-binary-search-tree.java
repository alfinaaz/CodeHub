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
    ArrayList<Integer> list= new ArrayList<>();
   TreeNode st1,st2=null;
    public void recoverTree(TreeNode root) {
        
        helper(root);
        int s1=-1;
        int s2=-1;
        boolean swapped_first_occurrence = false;
        for(int i=0;i<list.size()-1;++i)
        {
            
             if (list.get(i + 1) <list.get(i)) {
        s2 = list.get(i + 1);
        if (!swapped_first_occurrence) {
            // first swap occurrence
            s1 = list.get(i);
            swapped_first_occurrence = true;
        } else {
            // second swap occurrence
            break;
        }
      }
            
            
            
        }
        
        swap(root,s1,s2);
        
       if(st1!=null && st2!=null){
        int temp=st1.val;
        st1.val=st2.val;
        st2.val= temp;
        
        

    }
    }
    public void helper(TreeNode root)
    {
        
        if(root==null)
            return;
        
        helper(root.left);
        list.add(root.val);
        helper(root.right);
        
        
        
    }
    
    public void swap(TreeNode root,int x,int y)
    {
        if(root==null)
            return;
        
        if(root.val==x)
            st1=root;
        
        if(root.val==y)
            st2= root;
        
        
      swap(root.left,x,y);
      swap(root.right,x,y);
        
       /* if (r != null) {
      if (r.val == x || r.val == y) {
        r.val = r.val == x ? y : x;
        if (--count == 0) return;
      }
      swap(r.left, count, x, y);
      swap(r.right, count, x, y);
    }*/
        
  }
         
}

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
class Pair<T,V>
{
    T key;
    V value;
}
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return helper(root).key;
        
    }
    public Pair<Boolean,Pair<Long,Long>> helper(TreeNode root)
    {
                if(root==null)
                {
                    Pair<Boolean,Pair<Long,Long>> p= new Pair<>();
                    p.key=true;
                    p.value= new Pair<Long,Long>();
                    p.value.key=Long.MAX_VALUE;
                    p.value.value=Long.MIN_VALUE;
                    
                    return p;
                }
        
        
     
           Pair<Boolean,Pair<Long,Long>> l = helper(root.left);
          
        
      Pair<Boolean,Pair<Long,Long>> r= helper(root.right);
        
        Pair<Boolean,Pair<Long,Long>> ans= new Pair<>();
        boolean isBST=((root.val>l.value.value) && (root.val<r.value.key) && (l.key==true && r.key==true));
        //{
     //       ans.key=true;
    //    }
    //    else
      //      ans.key=false;
            
         ans.key=isBST;   
        ans.value= new Pair<Long,Long>();
        ans.value.key=Math.min(root.val,Math.min(l.value.key,r.value.key));
        ans.value.value=Math.max(root.val,Math.max(l.value.value,r.value.value));
        
     return ans;   
        
    }
}
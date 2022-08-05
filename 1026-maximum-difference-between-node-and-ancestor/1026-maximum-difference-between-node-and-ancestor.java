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

class Pair{
    
    int min;
    int max;
    
    public Pair(int min,int max)
    {
        this.min=min;
        this.max=max;
    }
}
class Solution {
    int diff=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        
         helper(root);
        
        return diff;
        
    }
    public Pair helper(TreeNode root)
    {
        
           if(root==null)
            return new Pair(-1,-1);
        
        int diff1,diff2,diff3,diff4,minimum,maximum=0;
        Pair l= helper(root.left);
        Pair r= helper(root.right);
        
        if(l.min!=-1 && r.min!=-1)
        {
            minimum=Math.min(root.val,Math.min(l.min,r.min));
            maximum=Math.max(root.val,Math.max(l.max,r.max));
            diff3=Math.abs(root.val-l.max);
            diff4=Math.abs(root.val-r.max);
            diff1=Math.abs(root.val-l.min);
            diff2=Math.abs(root.val-r.min);
            diff=Math.max(diff,Math.max(diff1,Math.max(diff2,Math.max(diff3,diff4))));
           
        }
        
        else if(l.min!=-1)
        {
             minimum=Math.min(root.val,l.min);
             maximum=Math.max(root.val,l.max);
             diff1=Math.abs(root.val-l.max);
             diff2=Math.abs(root.val-l.min);
             diff=Math.max(diff,Math.max(diff1,diff2));
        }
        else if(r.min!=-1)
        {
            minimum=Math.min(root.val,r.min);
            maximum=Math.max(root.val,r.max);                                                      diff2=Math.abs(root.val-r.max);
             diff1=Math.abs(root.val-r.min);
            diff=Math.max(diff,Math.max(diff1,diff2));
        }
        else
        {
             minimum=root.val;
             maximum=root.val;
        }
           
        
        
   //     if(l.max!=-1 && r.max!=-1){
   //         maximum=Math.max(root.val,Math.max(l.max,r.max);
   //         diff=Math.max(diff,root.val-Math.max(l.max,r.max));   
   //     }
        
     //   else if(l.max!=-1){
    //        maximum=Math.max(root.val,l.max);
    //         diff=Math.abs(root.val-l.max);
   //     }
    
  //      else if(r.max!=-1)
  //      {
   //             maximum=Math.max(root.val,r.max);
    //            diff=Math.max(diff,Math.abs(root.val-r.max));
                
   //     }
            

       // else{
            
         //    maximum=root.val;
           //   diff=Math.max(diff,root.val);
     //   }
           
                             
                             
        
     /*  int 
       int 
      int  
      int  
        
        int diff1=Math.max(d1,Math.max(d2,Math.max(d3,d4)));
        if(diff1>diff)
            diff=diff1;
        
         min=l==-1 &&Math.min(root.val,Math.min(l.min,r.min));
        int max=Math.max(root.val,Math.max(l.max,r.max));
        
        return new Pair(min,max);
        
        
  */
        
        
        
        
        
        
    return new Pair(minimum,maximum);
        
    }
    
    
}
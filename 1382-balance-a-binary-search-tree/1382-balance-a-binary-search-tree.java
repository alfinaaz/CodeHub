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
    List<Integer> arr = new ArrayList<Integer>();
    public TreeNode balanceBST(TreeNode root){
        
        if(root==null)
            return null;
        
         List<Integer> arr = new ArrayList<Integer>();
          convertToArray(root,arr);
         return helper(0,arr.size()-1,arr);
        
     //   if(root.left==null && root.right==null)
       //     return root;
        
        
         
        
        
    }
    public void convertToArray(TreeNode root,List<Integer> arr)
    {
        if(root==null)
            return;
     
      convertToArray(root.left,arr);
      arr.add(root.val);
      convertToArray(root.right,arr);
      
        
    }
    
    public TreeNode helper(int si,int ei,List<Integer> arr)
    {
        
        if(si>ei)
            return null;
        
        
        int mid=(si+ei)/2;
        
        TreeNode root= new TreeNode(arr.get(mid));
        root.left=helper(si,mid-1,arr);
        root.right=helper(mid+1,ei,arr);
        
        
        return root;
    }
}
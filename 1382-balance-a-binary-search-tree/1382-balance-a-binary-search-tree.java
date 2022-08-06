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
        
       //  List<Integer> arr = new ArrayList<Integer>();
          convertToArray(root);
         return helper(0,arr.size()-1);
        
     //   if(root.left==null && root.right==null)
       //     return root;
        
        
         
        
        
    }
    public void convertToArray(TreeNode root)
    {
        if(root==null)
            return;
     
      convertToArray(root.left);
      arr.add(root.val);
      convertToArray(root.right);
      
        
    }
    
    public TreeNode helper(int si,int ei)
    {
        
        if(si>ei)
            return null;
        
        
        int mid=(si+ei)/2;
        
        TreeNode root= new TreeNode(arr.get(mid));
        root.left=helper(si,mid-1);
        root.right=helper(mid+1,ei);
        
        
        return root;
    }
}
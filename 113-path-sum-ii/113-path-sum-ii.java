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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> pathList= new ArrayList<>();
        List<Integer> pathNodes= new ArrayList<>();
        
        helper(root,targetSum,pathNodes,pathList);
        return pathList;
    }
    public void helper(TreeNode root,int k,List<Integer> pathNodes, List<List<Integer>> pathList)
    {
        if(root==null)
            return;
        
        pathNodes.add(root.val);
        
        if(root.val==k && root.left==null && root.right==null)
            pathList.add(new ArrayList<>(pathNodes));
        
        else
        {
            helper(root.left,k-root.val,pathNodes,pathList);
            helper(root.right,k-root.val,pathNodes,pathList);
           
        }
        
        pathNodes.remove(pathNodes.size()-1);
        
        
        
        
        
    }
}
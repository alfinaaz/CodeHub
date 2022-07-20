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
    T first;
    V second;
    
    
}
class Solution {
    double max= Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        
       Pair<Integer,Double> ans= helper(root);
        return max;
    }
    public Pair<Integer,Double> helper(TreeNode root)
    {
            if(root==null)
            {
                Pair<Integer,Double> p= new Pair<>();
                p.first=0;
                p.second=(double)0;
                return p;
            }
            
            
            Pair<Integer,Double> ravg=helper(root.left);
           Pair<Integer,Double> lavg= helper(root.right);
           
           Pair<Integer,Double> avg = new Pair<>();
           avg.first= lavg.first+ravg.first+1;
           avg.second= (((lavg.second)*lavg.first)+  (ravg.second*ravg.first)+root.val)/(avg.first);
           
           max= Math.max(max,avg.second);
           return avg;
    }
}
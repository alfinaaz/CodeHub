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
    public TreeNode str2tree(String s) {
        
        return helper(s,0).getKey();
        
    }
    
    public Pair<Integer, Integer> getNumber(String s, int index) {
        
        boolean isNegative = false;
        
        // A negative number
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        }
            
        int number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            number = number * 10 + (s.charAt(index) - '0');
            index++;
        }
        
        return new Pair<Integer, Integer>(isNegative ? -number : number, index);
    } 
    
    public Pair<TreeNode,Integer> helper(String s, int idx)
    {
        if(idx==s.length())
            return new Pair<TreeNode,Integer>(null,idx);
    
        
    Pair<Integer,Integer> numData =getNumber(s,idx);
    TreeNode node = new TreeNode(numData.getKey());
    idx= numData.getValue();
    
    if(idx<s.length() && s.charAt(idx)=='(')
    {
        Pair<TreeNode,Integer> l = helper(s,idx+1);
        node.left=l.getKey();
        idx= l.getValue();
    }
        
    if(idx<s.length() && s.charAt(idx)=='(')
    {
        Pair<TreeNode,Integer> r = helper(s,idx+1);
        node.right=r.getKey();
        idx= r.getValue();
    }
        
         return new Pair<TreeNode, Integer>(node, idx < s.length() && s.charAt(idx) == ')' ? idx + 1 : idx);
    
}
}
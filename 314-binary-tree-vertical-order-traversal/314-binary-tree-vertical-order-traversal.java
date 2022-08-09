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
    Map<Integer,List<Integer>> map= new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        
        
        List<List<Integer>> ans= new ArrayList<>();
        
        if(root==null)
            return ans;
        Queue<Pair<TreeNode,Integer>> q= new LinkedList<>();
        q.add(new Pair<TreeNode,Integer>(root,0));
        while(!q.isEmpty())
        {
            Pair<TreeNode,Integer> p= q.remove();
            if(!(map.containsKey(p.getValue())))
            {
                 List<Integer> list= new ArrayList<>();
                 list.add(p.getKey().val);
                 map.put(p.getValue(),list);
            }
            else
            {
                List<Integer> list= map.get(p.getValue());
                list.add(p.getKey().val);
                map.put(p.getValue(),list);
            }
            
            
            
            if(p.getKey().left!=null)
            {
                q.add(new Pair(p.getKey().left,p.getValue()-1));
            }
            
             if(p.getKey().right!=null)
            {
                q.add(new Pair(p.getKey().right,p.getValue()+1));
            }
            
   
        }
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet())
        {
            ans.add(entry.getValue());
        }
        
        return ans;
        
    }
}
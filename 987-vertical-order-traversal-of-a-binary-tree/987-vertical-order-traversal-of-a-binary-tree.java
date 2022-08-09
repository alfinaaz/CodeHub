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

 class Pair<T,V>{
    
    T first;
    V second;
    public Pair(T first, V second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
   Map<Integer,List<Pair<Integer,Integer>>> map= new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans= new ArrayList<>();
        Queue<Pair<TreeNode,Pair<Integer,Integer>>> q= new LinkedList<>();
        q.add(new Pair<TreeNode,Pair<Integer,Integer>>(root,new Pair<>(0,0)));
        while(!q.isEmpty())
        {
            Pair<TreeNode,Pair<Integer,Integer>> p= q.remove();
           
                if(!map.containsKey(p.second.first))
                {
                    List<Pair<Integer,Integer>> arr= new ArrayList<>();
                    arr.add(new Pair<Integer,Integer>(p.first.val,p.second.second));
                    map.put(p.second.first,arr);
                }
                 else
            {
                List<Pair<Integer,Integer>> arr = map.get(p.second.first);
                 arr.add(new Pair<Integer,Integer>(p.first.val,p.second.second));
                 Collections.sort(arr, (p1, p2) ->p1.second==p2.second?p1.first-p2.first:p1.second-p2.second);
                 map.put(p.second.first,arr);
                
            }
            if(p.first.left!=null)
            {
                q.add(new Pair<TreeNode,Pair<Integer,Integer>>(p.first.left,new Pair<Integer,Integer>(p.second.first-1,p.second.second+1)));
            }
            if(p.first.right!=null)
            {
                 q.add(new Pair<TreeNode,Pair<Integer,Integer>>(p.first.right,new Pair<Integer,Integer>(p.second.first+1,p.second.second+1)));
            }
           
        }
        
        for(Map.Entry<Integer,List<Pair<Integer,Integer>>> entry:map.entrySet())
        {
            
            Collections.sort(entry.getValue(),new Comparator<Pair<Integer,Integer>>()
            {
                @Override
                public int compare(Pair<Integer,Integer>p1, Pair<Integer,Integer> p2)
                {
                    if(p1.second.equals(p2.second))
                         return p1.first-p2.first;
                    
                    else
                        return p1.second-p2.second;
                        
                }
            });
            
            
            List<Integer> sortedColumn = new ArrayList();
            for(Pair<Integer,Integer> p: entry.getValue())
            {
                sortedColumn.add(p.first);
            }
            ans.add(sortedColumn);
            
            
            }
            
            
            
           // List<Integer> list= new ArrayList<>();
           // for(int i=0;i<entry.getValue().size();i++)
            //{
              //  list.add(entry.getValue().get(i).first);
            //}
            //ans.add(list);
        return ans;
        
    }
}
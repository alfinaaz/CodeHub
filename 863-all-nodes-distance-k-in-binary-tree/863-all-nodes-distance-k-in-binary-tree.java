/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list= new ArrayList<>();
        
        if(k==0)
        {
            list.add(target.val);
            return list;
        }
        HashMap<TreeNode,TreeNode> map= new HashMap<>();
        boolean[] visited= new boolean[501];
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            
            TreeNode front= q.remove();
            if(front.left!=null)
            {
                map.put(front.left,front);
                q.add(front.left);
            }
            if(front.right!=null)
            {
                map.put(front.right,front);
                q.add(front.right);
            }
             
        }
        Queue<TreeNode> q1= new LinkedList<>();
        q1.add(target);
        while(!q1.isEmpty())
        {
            int size=q1.size();
            while(size>0)
            {            
                TreeNode front1= q1.remove();
                visited[front1.val]=true;
            
            if(front1.left!=null &&(!visited[front1.left.val]))
            {
                q1.add(front1.left);
                visited[front1.left.val]=true;
            }
            if(front1.right!=null && !visited[front1.right.val] )
            {
                q1.add(front1.right);
                 visited[front1.right.val]=true;
            
            }
            if(map.containsKey(front1)&&(!visited[(map.get(front1)).val]))
            {
                q1.add(map.get(front1));
                visited[front1.val]=true;
            
            
            }
            size--;
                
            }
            k--;
            if(k==0)
                break;
            
        }
        
        while(!q1.isEmpty())
        {
            list.add(q1.remove().val);
            
        }
        
        return list;
        
    }
}
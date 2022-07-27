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
    
    class Pair<K,V>{
        
        K key;
        V value;
        
        public Pair(K key, V value){
            
            this.key=key;
            this.value=value;
            
        }
         public K getKey() {
        return this.key;
    }
     public V getValue() {
        return this.value;
    }
}
    public void flatten(TreeNode root) {
        
      if(root==null)
          return;
        
        int START=1,END=2;
        TreeNode tailNode=null;
        
        Stack<Pair<TreeNode,Integer>> stack= new Stack<Pair<TreeNode,Integer>>();
        stack.push(new Pair<TreeNode,Integer>(root,START));
        
        while(!stack.isEmpty())
        {
            
            Pair<TreeNode,Integer> nodeData= stack.pop();
            TreeNode currentNode= nodeData.getKey();
            int recursionState=nodeData.getValue();
            
            
             if (currentNode.left == null && currentNode.right == null) {
                tailNode = currentNode;
                continue;
            }
            
            if(recursionState==START)
            {
                
                if(currentNode.left!=null)
                {
                    stack.push(new Pair<TreeNode,Integer>(currentNode,END));
                    stack.push(new Pair<TreeNode,Integer>(currentNode.left,START));
                    
                }
                
                else if(currentNode.right!=null)
                {
                      stack.push(new Pair<TreeNode,Integer>(currentNode.right,START));
                }
                
                
                
            }
            
            else
            {
                TreeNode rightNode = currentNode.right;
              //  if(tailNode!=null)
              //  {
                    tailNode.right=currentNode.right;
                    currentNode.right=currentNode.left;
                    currentNode.left=null;
                    rightNode=tailNode.right;
              //  }
                if(rightNode!=null)
                         stack.push(new Pair<TreeNode, Integer>(rightNode, START));
                
                
            }
            
            
            
            
            
        }
        
        
        
    }
}
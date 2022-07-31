/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
import java.util.*;
class Solution {
    public Node connect(Node root) {
        
        if(root==null)
            return root;
        
        Queue<Node> q = new LinkedList<>();
         //
        q.add(root);
        Node node= new Node();
       // node=null;
        q.add(node);
        while(!(q.isEmpty()))
        {
            Node f= q.remove();
            
             if(f.left!=null)
                q.add(f.left);
            
            if(f.right!=null)
                q.add(f.right);
            
           
            if(q.peek()!=node) 
                f.next=q.peek();
            else
            {
                 q.poll();
                 q.add(node);
            }
               
           
        }
        
        return root;
        
    }
}
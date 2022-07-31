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

class Solution {
    Node prev=null,leftmost=null;
    public Node connect(Node root) {
        
        
        if(root==null)
            return root;
        
        this.leftmost=root;
        Node curr= leftmost;
        while(this.leftmost!=null)
        {
             this.prev=null;
             curr=this.leftmost;
            this.leftmost=null;
            while(curr!=null)
            {
                process(curr.left);
                process(curr.right);
                
                curr=curr.next;
            }        
            
        }
        
        return root;
       
        
    }
    
    
    public void process(Node childNode)
    {
        
       
        
        if(childNode!=null)
        {
            
            if(prev!=null)
            {
                this.prev.next=childNode;
                //prev=prev.next;
            }
            else
            {
                this.leftmost=childNode;
            }
            
            this.prev=childNode;
                
        }
        
    }
}
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
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        
        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node p = root;
        
        // Once we reach the final level, we are done
        while ( p.left!= null) {
            
            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the 
            // corresponding links for the next level
            Node q = p;
            
            while (q!= null) {
                
                // CONNECTION 1
                q.left.next = q.right;
                
                // CONNECTION 2
                if (q.next != null) {
                    q.right.next = q.next.left;
                }
                
                // Progress along the list (nodes on the current level)
                q = q.next;
            }
            
            // Move onto the next level
            p= p.left;
        }
        
        return root;
    }
}
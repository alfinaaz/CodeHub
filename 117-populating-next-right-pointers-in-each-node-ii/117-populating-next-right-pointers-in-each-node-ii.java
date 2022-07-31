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
       Node connect(Node root) {
        Node temp = null;
   
        if (root == null)
            return root;
        Node p=root;
        // Set nextRight for root
        p.next = null;
   
        // set nextRight of all levels one by one
        while (p != null) 
        {
            Node q = p;
   
            /* Connect all children nodes of p and children nodes of all other
               nodes at same level as p */
            while (q != null) 
            {
                // Set the nextRight pointer for p's left child
                if (q.left != null) 
                {
                   
                    // If q has right child, then right child is nextRight of
                    // p and we also need to set nextRight of right child
                    if (q.right != null)
                        q.left.next = q.right;
                    else
                        q.left.next = getNextRight(q);
                }
   
                if (q.right != null)
                    q.right.next = getNextRight(q);
   
                // Set nextRight for other nodes in pre order fashion
                q = q.next;
            }
   
            // start from the first node of next level
            if (p.left != null)
                p = p.left;
            else if (p.right != null)
                p = p.right;
            else
                p = getNextRight(p);
        }
           return root;
    }
     Node getNextRight(Node p) 
    {
        Node temp = p.next;
   
        /* Traverse nodes at p's level and find and return
           the first node's first child */
        while (temp != null) 
        {
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.next;
        }
   
        // If all the nodes at p's level are leaf nodes then return NULL
        return null;
    }
}
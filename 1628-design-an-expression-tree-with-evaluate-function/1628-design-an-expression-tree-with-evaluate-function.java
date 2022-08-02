/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};
class TreeNode extends Node {
    
    String val;
    Node left;
    Node right;
    int ans;
    
    public TreeNode(String val)
    {
        this.val=val;
        left=null;
        right=null;
        this.ans=Integer.MAX_VALUE;
        
    }

    // private String[] postfix;
   // private static Set<String> op = Set.of("+", "-", "*", "/");

  //  public TreeNode(String[] postfix) {
    //    this.postfix = postfix;
    //}

    public int evaluate()
    {
        
       return this.ans;
        
    }
}



/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    int idx=0;
    Node buildTree(String[] postfix) {
        //String operators = "+-*/";
        
        Stack<TreeNode> st = new Stack<>();
        while(idx<postfix.length)
        {
            
            if(postfix[idx].equals("*") || postfix[idx].equals("-") || postfix[idx].equals("/")|| postfix[idx].equals("+"))
            {
                 TreeNode r=st.pop();
                TreeNode l= st.pop();
                TreeNode root= new TreeNode(postfix[idx]);
                root.left=l;
                root.right=r;
                root.ans=calculate(l,r,postfix[idx]);
                st.push(root);      
            }
            else
            {
                TreeNode nd= new TreeNode(postfix[idx]);
               // nd.ans=Integer.parseInt(postfix[idx]);
                st.push(nd);
            }
            idx++;
            
        }
        
        return (Node)st.pop();
        
    }
    public int calculate(TreeNode l,TreeNode r,String op)
    {
        
        if(l.ans==Integer.MAX_VALUE)
            l.ans=Integer.parseInt(l.val);
        
        
        if(r.ans==Integer.MAX_VALUE)
               r.ans=Integer.parseInt(r.val);
        
        
        if(op.equals("*"))
            return l.ans*r.ans;
        
     if(op.equals("/"))
            return l.ans/r.ans;
        
        if(op.equals("+"))
            return l.ans+r.ans;
        
       if(op.equals("-"))
            return l.ans-r.ans;
        
        
        return -1;
        
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
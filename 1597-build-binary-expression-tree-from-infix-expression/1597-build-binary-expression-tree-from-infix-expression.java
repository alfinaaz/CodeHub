/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     int Prec(char ch)
    {
        switch (ch) {
        case '+':
        case '-':
            return 1;
 
        case '*':
        case '/':
            return 2;
 
        case '^':
            return 3;
        }
        return -1;
    }
    int idx;
    public Node expTree(String s) {
        
        String str=convertToPostfix(s);
        this.idx=str.length()-1;
        return helper(str);
    }
    
    public Node helper(String str)
    {
        if(idx<0)
            return null;
        
        if(Character.isDigit(str.charAt(idx)))
        {
            Node node= new Node(str.charAt(idx));
            idx--;
            return node;
            
        }
        
        Node root= new Node(str.charAt(idx));
        idx--;
        root.right=helper(str);
        root.left=helper(str);
        
        return root; 
        
    }
    public String convertToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");
 
        // initializing empty stack
        Deque<Character> stack
            = new ArrayDeque<Character>();
 
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
 
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
 
            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
                stack.push(c);
 
            //  If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty()
                       && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }
 
                stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty()
                       && Prec(c) <= Prec(stack.peek())) {
 
                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }
 
        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }
       
        return result;
    }
 
}
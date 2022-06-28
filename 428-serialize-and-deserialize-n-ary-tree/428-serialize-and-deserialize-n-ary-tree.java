/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        
        if(root==null)
            return "";
        StringBuilder sb= new StringBuilder();
         shelper(root,sb);
        return sb.toString();
        
    }
    public StringBuilder shelper(Node root, StringBuilder sb)
    {
        
        Queue<Node> q = new LinkedList<>();
        Node c = new Node();
        Node e= new Node();
        q.add(root);
        q.add(e);
        
        while(!q.isEmpty())
        {
            Node p= q.remove();
            
            if(p==e)
            {
                sb.append("#");
                if(!q.isEmpty())
                     q.add(e);
            }
            
            else if(p==c)
                sb.append("$");
            
            
            else{
                sb.append((char)(p.val+'0'));
                for(Node child : p.children)
                {
                    q.add(child);
                }
            
            if(q.peek()!=e)
                
                q.add(c);
            }        
        }
        return sb;
        
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        
        if (data.isEmpty()) {
            return null;
        }
            
        Node rootNode = new Node(data.charAt(0) - '0', new ArrayList<Node>());
       dhelper(data, rootNode);
       return rootNode;
        
        
    }
    
    public void dhelper(String data, Node rootNode)
    {
         LinkedList<Node> currentLevel = new LinkedList<Node>();
        LinkedList<Node> prevLevel = new LinkedList<Node>();
        currentLevel.add(rootNode);
        Node parentNode = rootNode;
        
        // Process the characters in the string one at a time.
        for (int i = 1; i < data.length(); i++) {
            char d = data.charAt(i);
            if (d == '#') {
                // Special processing for end of level. We need to swap the
                // array lists. Here, we simply re-initialize the "currentLevel"
                // arraylist rather than clearing it.
                prevLevel = currentLevel;
                currentLevel = new LinkedList<Node>();
                
                // Since we move one level down, we take the parent as the first
                // node on the current level.
                parentNode = prevLevel.poll();
            } else {
                if (d == '$') {
                    
                    // Special handling for change in parent on the same level
                    parentNode = prevLevel.poll();
                } else {
                    Node childNode = new Node(d - '0', new ArrayList<Node>());    
                    currentLevel.add(childNode);
                    parentNode.children.add(childNode);
                }
            }
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
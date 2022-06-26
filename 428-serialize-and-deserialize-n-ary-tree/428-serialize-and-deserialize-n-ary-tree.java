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
    class WrappableInt{
        private int value;
        
        public WrappableInt(int x)
        {
            this.value=x;
        }
        public int getValue()
        {
            return this.value;
        }
        
        public void increment()
        {
            this.value++;
        }
        
    }
    
    class DO extends HashMap<Integer, Pair<Integer,Pair<Integer,Node>>>
    {
        
    }
    
    public String serialize(Node root) {
        WrappableInt idx = new WrappableInt(1);
        StringBuilder sb = new StringBuilder();
         shelper(root,idx,sb,-1);
        return sb.toString();
    }
    public void shelper(Node root,  WrappableInt idx, StringBuilder sb,int parentIndex)
    {
        
        if(root==null)
            return ;
        
        sb.append((char)(idx.getValue()+'0'));
        sb.append((char)(root.val+'0'));
        sb.append((char)(parentIndex==-1?'N':parentIndex+'0'));
        
        parentIndex=idx.getValue();
       
        for(Node child: root.children)
        {
             idx.increment();
             shelper(child,idx,sb,parentIndex);
        }
        
       
        
        
    }
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        
        if(data.isEmpty())
            return null;
        
        DO nodesandParents= new DO();
       
        for(int i=0;i<data.length();i=i+3)
        {
            int id= data.charAt(i) - '0';
            int val= data.charAt(i+1) - '0';
            int pidx= data.charAt(i+2) -'0';
            Pair<Integer,Pair<Integer,Node>> node = new Pair<Integer,Pair<Integer,Node>>(val,new Pair<Integer,Node>(pidx,new Node(val,new ArrayList<Node>())));
            
            nodesandParents.put(id,node);
            
        }
        
        for(int i=3;i<data.length();i+=3)
        {
            int id= data.charAt(i)-'0';
            int val= data.charAt(i+1)-'0';
            int pidx= data.charAt(i+2)-'0';
            
    Node child  = nodesandParents.get(id).getValue().getValue();
    Node parent= nodesandParents.get(pidx).getValue().getValue();
            
            parent.children.add(child);
            
        }
        
        return nodesandParents.get(1).getValue().getValue();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
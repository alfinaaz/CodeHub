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
        
        StringBuilder sb= new StringBuilder();
        serializehelper(root,sb);
        return sb.toString();
        
    }
     public StringBuilder serializehelper(Node root, StringBuilder sb) {
        
       if(root==null)
       {
           return sb;
       }     
     sb.append(root.val);
     sb.append(",");
     sb.append(root.children.size());
     sb.append(",");
     
    for(int i=0;i<root.children.size();i++)
    {
        serializehelper(root.children.get(i),sb);
    }
    
         
         return sb;
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data=="")
            return null;
        
        String[] arr = data.split(",");
        List<String> arr1 = new ArrayList<String>(Arrays.asList(arr));
        
        return deserializehelper(arr1);
        
    }
     public Node deserializehelper(List<String> arr1) {
         
       //  if(arr1.size()==0)
         //    return null;
         
         int data = Integer.parseInt(arr1.get(0));
         int numChild= Integer.parseInt(arr1.get(1));
         
         arr1.remove(0);
         arr1.remove(0);
         
         List<Node> children = new ArrayList<>();
         Node root= new Node(data,children);
         for(int i=0;i<numChild;i++)
         {
             Node childNode= deserializehelper(arr1);
             root.children.add(childNode);
         }
         
         return root;
         
}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
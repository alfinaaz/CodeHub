/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        return serializehelper(root,"");
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         
     String[] data_array = data.split(",");
    List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
    return rdeserialize(data_list);
  }



 public TreeNode rdeserialize(List<String> l) {
    // Recursive deserialization.
    if (l.get(0).equals("null")) {
      l.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
    l.remove(0);
    root.left = rdeserialize(l);
    root.right = rdeserialize(l);

    return root;
  }


    
    public String serializehelper(TreeNode root, String str)
    {
        if(root==null)
        {
            str+="null,";
        }
        else
        {
            str+=str.valueOf(root.val)+",";
            str=serializehelper(root.left,str);
            str=serializehelper(root.right,str);
           
        }
        
        return str;
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
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
        
           return  serialize1(root,"");
        
    }
    
    public String serialize1(TreeNode root, String str)
    {
        if(root==null)
        {
            str+="null,";
           
        }
        
        else
        {
            str+=str.valueOf(root.val)+",";
            str= serialize1(root.left,str);
            str= serialize1(root.right,str);
            
            
            
        }     
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
          String[] arr = data.split(",");
          List<String> arr1 = new ArrayList(Arrays.asList(arr));
        
         return deserialize(arr1);            
    }
    public TreeNode deserialize(List<String> arr) {
        
          if((arr.get(0).equals("null")))
          {
              arr.remove(0);
              return null;
          }
             TreeNode root = new TreeNode(Integer.parseInt(arr.get(0)));
             arr.remove(0);
             root.left=deserialize(arr);
             root.right=deserialize(arr);
             
    
        return root;
        
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
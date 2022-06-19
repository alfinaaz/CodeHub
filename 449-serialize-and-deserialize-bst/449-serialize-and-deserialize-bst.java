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
        
        return  rserialize(root, "");
        
    }
    
    public String rserialize(TreeNode root,String str)
    {
        if(root==null)
        {
            str+="null,";
            return str;
        }
        
        str+=str.valueOf(root.val)+",";
        str=rserialize(root.left,str);
        str=rserialize(root.right,str);
        
        return str;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr= data.split(",");
        List<String> arr1 = new ArrayList<>(Arrays.asList(arr));
        
        return rdeserialize(arr1);
    }
    
    public TreeNode rdeserialize(List<String> arr)
    {
        if(arr.get(0).equals("null"))
        {
            arr.remove(0);
            return null;
        }
            
        
        TreeNode root = new TreeNode(Integer.parseInt(arr.get(0)));
        arr.remove(0);
        root.left=rdeserialize(arr);
        root.right=rdeserialize(arr);
        
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
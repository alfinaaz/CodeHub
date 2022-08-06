/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   int height[];
public void updateHeight(TreeNode root){
    int lh = root.left != null ? height[root.left.val] : -1;
    int rh = root.right != null ? height[root.right.val] : -1;
    
    height[root.val] = Math.max(lh,rh) + 1;
}

public int getBal(TreeNode root){
    int lh = root.left != null ? height[root.left.val] : -1;
    int rh = root.right != null ? height[root.right.val] : -1;
    return lh - rh;
}

public TreeNode leftRotation(TreeNode A){
    TreeNode B = A.right;
    TreeNode BkaLeft = B.left;
    
    B.left = A;
    A.right = BkaLeft;
    
    B.left = getRotation(A);
    return getRotation(B);
}

public TreeNode rightRotation(TreeNode A){
    TreeNode B = A.left;
    TreeNode BkaRight = B.right;
    
    B.right = A;
    A.left = BkaRight;
    
    B.right = getRotation(A);
    return getRotation(B);
}

public TreeNode getRotation(TreeNode root){
    updateHeight(root);
    if(getBal(root) >= 2){   // ll, lr
        if(getBal(root.left) >= 1){  // ll
            return rightRotation(root);    
        }else{    // lr
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
    }else if(getBal(root) <= -2){  // rr,rl
        if(getBal(root.right) <= -1){   // rr
            return leftRotation(root);
        }else{ // rl
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
    }
    return root;
}

public TreeNode postOrder(TreeNode root){
    if(root == null) return null;
    
    root.left = postOrder(root.left);
    root.right = postOrder(root.right);
    
    return getRotation(root);
}

public TreeNode balanceBST(TreeNode root) {
    height = new int[100001];
    return postOrder(root);
}
    
}
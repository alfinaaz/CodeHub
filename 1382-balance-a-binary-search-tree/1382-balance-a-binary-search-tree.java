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
 public TreeNode balanceBST(TreeNode root) {
    List<Integer> treeArr = new ArrayList<>();
    inOrder(root,treeArr);
    return createBalanceFromArr(treeArr,0,treeArr.size()-1);
}

public TreeNode createBalanceFromArr(List<Integer> treeArr, int start, int end)
{
    if(start>end)
    {
        return null;
    }
    
    int mid = (start+end)/2;
    TreeNode left = createBalanceFromArr(treeArr,start,mid-1);
    TreeNode right = createBalanceFromArr(treeArr,mid+1,end);
    TreeNode node = new TreeNode(treeArr.get(mid),left,right);
    return node;
}

public void inOrder(TreeNode node, List<Integer> treeArr){
    if(node!=null)
    {
        inOrder(node.left,treeArr);
        treeArr.add(node.val);
        inOrder(node.right,treeArr);
    }
}

}
//输入两颗二叉树A，B，判断B是不是A的子结构。

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null){
            return false;
        }
        return IsSubtree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    public boolean IsSubtree(TreeNode t1,TreeNode t2){
        if(t2==null)
            return true;
        if(t1==null)
            return false;
        if(t1.val==t2.val)
           return IsSubtree(t1.left,t2.left)&&IsSubtree(t1.right,t2.right);
        else 
            return false;
    }
}
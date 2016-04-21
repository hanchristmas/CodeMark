//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
//使用两个队列一个存放节点，一个存放值。先将根节点加入到队列中，然后遍历队列中的元素，遍历过程中，访问该元素的左右节点，再将左右子节点加入到队列中来。

import java.util.ArrayList;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> listNode=new ArrayList<TreeNode>();
        ArrayList<Integer> listVal=new ArrayList<Integer>();
        if(root==null) return listVal;
        listNode.add(root);
        listVal.add(root.val);
        for(int i=0;i<listNode.size();i++){
            TreeNode temp=listNode.get(i);
            if(temp.left!=null){
                listNode.add(temp.left);
                listVal.add(temp.left.val);
            }
            if(temp.right!=null){
                listNode.add(temp.right);
                listVal.add(temp.right.val);
            }
        }
        return listVal;
    }
}
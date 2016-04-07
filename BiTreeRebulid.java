 //输入某二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}。

 // Definition for binary tree
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=Construct(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    
    public TreeNode Construct(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
		if(preStart>preEnd||inStart>inEnd)
            return null;
        TreeNode root =new TreeNode(pre[preStart]);
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==pre[preStart]){
            	//每次更新当前左子树和右子树在输入两个序列中的起始与终止索引。
                root.left=Construct(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right=Construct(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
            }
        }
        return root;
       
    }
}
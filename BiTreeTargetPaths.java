//输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
//路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。


//递归查找：
//先判断是不是叶子节点
//如果是：若数值匹配，则添加到pathList。
//如不是：此节点值入栈，检查左子树与右子树。

import java.util.ArrayList;
import java.util.Stack;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> pathList=new ArrayList<ArrayList<Integer>>();
        if(root==null) 
            return pathList;
        Stack<Integer> path=new Stack<Integer>();
   	    findPath(root,target,path,pathList); 
        return pathList;
    }
    
    public void findPath(TreeNode root,int target,Stack<Integer> path,ArrayList<ArrayList<Integer>> pathList){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            if(root.val==target){
                ArrayList<Integer> pathTemp=new ArrayList<Integer>();
                for(int i:path){
                    pathTemp.add(new Integer(i));
                }
                pathTemp.add(new Integer(root.val));
                pathList.add(pathTemp);
            }
        }
        else{
            path.push(new Integer(root.val));
            findPath(root.left,target-root.val,path,pathList);
            findPath(root.right,target-root.val,path,pathList);
            path.pop();
        }
    }
}
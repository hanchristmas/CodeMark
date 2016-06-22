// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree [1,null,2,3],
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<Integer>();
        if(root==null)
            return result;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode p = root;
        while(!nodeStack.empty()||p!=null){
            if(p!=null){
                nodeStack.push(p);
                p=p.left;
            }else{
                p=nodeStack.pop();
                result.add(p.val);
                p=p.right;
            }
        }
        return result;
    }
}
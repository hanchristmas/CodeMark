// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root==null)
            return result;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode p = root;
        nodeStack.push(p);
        while(!nodeStack.empty()){
            p = nodeStack.pop();
            result.add(p.val);
            if(p.right!=null)
                nodeStack.push(p.right);
            if(p.left!=null)
                nodeStack.push(p.left);
        }
        return result;
        
    }
}
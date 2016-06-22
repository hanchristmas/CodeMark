// Given a binary tree, return the postorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [3,2,1].

// Note: Recursive solution is trivial, could you do it iteratively?

// 对于后序遍历，首先遍历左子树，然后是右子树，最后才是根节点。
// 当遍历到一个节点的时候，首先我们将右子树压栈，然后将左子树压栈。
// 这里需要注意一下出栈的规则，对于叶子节点来说，直接可以出栈；
// 但是对于根节点来说，我们需要一个变量记录上一次出栈的节点；
// 如果上一次出栈的节点是该根节点的左子树或者右子树，那么该根节点可以出栈；
// 否则这个根节点是新访问的节点，将右和左子树分别压栈。

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<Integer>();
        if(root==null)
            return result;
        Stack<TreeNode> nodeStack=new Stack<TreeNode>();
        TreeNode p=null;
        TreeNode pre=null;
        nodeStack.push(root);
        while(!nodeStack.empty()){
            p=nodeStack.peek();
            if((p.left==null&&p.right==null)||(pre!=null&&(pre==p.left||pre==p.right))){
                p=nodeStack.pop();
                result.add(p.val);
                pre=p;
            }else{
                if(p.right!=null)
                    nodeStack.push(p.right);
                if(p.left!=null)
                    nodeStack.push(p.left);
            }
        }
        return result;
    }
}
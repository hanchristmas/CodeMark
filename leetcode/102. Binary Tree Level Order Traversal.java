// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

// It is obvious that this problem can be solve by using a queue.
//  However, if we use one queue we can not track when each level starts. 
// So we use two queues to track the current level and the next level.

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> levelResult=new ArrayList<Integer>();
        if(root==null)
            return resultList;
        LinkedList<TreeNode> cur=new LinkedList<TreeNode>();
        LinkedList<TreeNode> next=new LinkedList<TreeNode>();
        cur.add(root);
        while(!cur.isEmpty()){
            TreeNode p=cur.remove();
            if(p.left!=null)
                next.add(p.left);
            if(p.right!=null)
                next.add(p.right);
                
            levelResult.add(p.val);
            
            if(cur.isEmpty()){
                cur=next;
                next=new LinkedList<TreeNode>();
                resultList.add(levelResult);
                levelResult=new ArrayList<Integer>();
            }
            
        }
        return resultList;
    }
}
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]

// 运用LinkedList的四个方法 getFirst()  getLast()  addFirst() addLast()

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList=new ArrayList<List<Integer>>();
        if(root==null)
            return resultList;
        boolean flag=true;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        List<Integer> levelResult=new ArrayList<Integer>();
        queue.add(root);
        TreeNode p;
        while(!queue.isEmpty()){
            if(flag){
                TreeNode last=queue.getLast();
                do{
                   p=queue.getFirst();
                   levelResult.add(p.val);
                   if(p.left!=null)
                        queue.addLast(p.left);
                   if(p.right!=null)
                        queue.addLast(p.right);
                   queue.removeFirst();
                   if(queue.isEmpty())
                        break;
                }while(p!=last);
            }else{
                TreeNode first=queue.getFirst();
                do{
                    p=queue.getLast();
                    levelResult.add(p.val);
                    if(p.right!=null)
                        queue.addFirst(p.right);
                    if(p.left!=null)
                        queue.addFirst(p.left);
                    queue.removeLast();
                    if(queue.isEmpty())
                        break;
                }while(p!=first);
            }
            
            resultList.add(levelResult);
            levelResult=new ArrayList<Integer>();
            flag=!flag;
        }
        return resultList;
    }
}
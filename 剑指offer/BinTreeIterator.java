
//前序遍历
public List<TreeNode> preIterator(){
	return preIterator(root);
}

private List<TreeNode> preIterator(TreeNode node){
	List<TreeNode> list=new ArrayList<TreeNode>();
	list.add(node);
	if(node.left!=null)
		list.addAll(preIterator(node.left));
	if(node.right!=null)
		list.addAll(preIterator(node.right));
	return list;
}


//中序遍历
public List<TreeNode> preIterator(){
	return preIterator(root);
}

private List<TreeNode> inIterator(TreeNode node){
	List<TreeNode> list=new ArrayList<TreeNode>();	
	if(node.left!=null)
		list.addAll(inIterator(node.left));
	list.add(node);
	if(node.right!=null)
		list.addAll(inIterator(node.right));
	return list;
}


//后序遍历
public List<TreeNode> postIterator(){
	return postIterator(root);
}

private List<TreeNode> postIterator(TreeNode node){
	List<TreeNode> list=new ArrayList<TreeNode>();	
	if(node.left!=null)
		list.addAll(postIterator(node.left));
	if(node.right!=null)
		list.addAll(postIterator(node.right));
	list.add(node);
	return list;
}

//广度优先遍历
public List<TreeNode> BreadthFirst(){
	Queue<TreeNode> queue=new ArrayDeque<TreeNode>();
	List<TreeNode> list=new ArrayList<TreeNode>();
	if(root!=null){
		queue.offer(root);
	}
	while(!queue.isEmpty()){
		list.add(queue.peek());
		TreeNode p=queue.poll();
		if(p.left!=null){
			queue.offer(p.left);
		}
		if(p.right!=null){
			queue.offer(p.right);
		}
	}
	return list;
}
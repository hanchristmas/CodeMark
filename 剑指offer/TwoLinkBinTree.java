
public class TwoLinkBinTree<T>{
	public class TreeNode<T>{
		T data;
		TreeNode left;
		TreeNode right;
		public TreeNode(){

		}

		public TreeNode(T data){
			this.data=data;
		}

		public TreeNode(T data,TreeNode left,TreeNode right){
			this.data=data;
			this.left=left;
			thi.right=right;
		}
	}

	private TreeNode root;

	public TwoLinkBinTree(){
		this.root=new TreeNode();
	}

	public TwoLinkBinTree(T data){
		this.root=new TreeNode(data);
	}

	public TreeNode addNode(TreeNode parent,T data,boolean isLeft){
		if(parent==null){
			throw new RuntimeException("父节点为空，无法添加");
		}
		if(isLeft&&parent.left!=null){
			throw new RuntimeException("已有左子节点");
		}
		if(!isLeft&&parent.right!=null){
			throw new RuntimeException("已有右子节点");
		}
		TreeNode newNode=new TreeNode(data);
		if(isLeft){
			parent.left=newNode;
		}
		else{
			parent.left=newNode;
		}
		return newNode;
	}

	public boolean isEmpty(){
		return root.data==null;
	}

	public TreeNode root(){
		if(isEmpty)
			throw new RuntimeException("树为空");
		return root;
	}

	public T parent(TreeNode){
		//遍历二叉树
	}

	public T leftChild(TreeNode parent){
		if(parent==null){
			throw new RuntimeException("节点为空");
		}
		return parent.left==null?null:parent.left.data;
	}

	public T rightChild(TreeNode parent){
		if(parent==null){
			throw new RuntimeException("节点为空");
		}
		return parent.right==null?null:parent.right.data;
	}

	public int deep(){
		return deep(root);
	}

	private int deep(TreeNode node){
		if(node==null){
			return 0;
		}
		if(node.left==null&&node.right==null){
			return 1;
		}
		else{
			int leftDeep=deep(node.left);
			int rightDeep=deep(node.right);
			int max=leftDeep>rightDeep?leftDeep:rightDeep;
			return max+1;
		}
	}
}
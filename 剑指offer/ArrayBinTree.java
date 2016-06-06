import java.lang.*;
import java.util.*;

public class ArrayBinTree<T>{
	//使用数组记录所有节点
	private Object[] datas;
	private int DEFAULT_DEEP=8;
	//保存树的深度
	private int deep;
	private int arraySize;
	//以默认深度创建二叉树
	public ArrayBinTree(){
		this.deep=DEFAULT_DEEP;
		this.arraySize=(int)Math.pow(2,deep)-1;
		datas=new Object[arraySize];
	}
	//指定深度
	public ArrayBinTree(int deep){
		this.deep=deep;
		this.arraySize=(int)Math.pow(2,deep)-1;
		datas=new Object[arraySize];
	}
	//指定深度，指定根节点
	public ArrayBinTree(int deep，T root){
		this.deep=deep;
		this.arraySize=(int)Math.pow(2,deep)-1;
		datas=new Object[arraySize];
		datas[0]=root;
	}

	//为指定节点添加子节点
	public void add(int index,T data,boolean left){
		if(datas[index]==null){
			throw new RuntimeException(index+"处父节点为空");
		}
		if(2*index+1>=arraySize){
			throw new RuntimeException("树越界异常")；
		}
		if(left){
			datas[2*index+1]=data;
		}
		else{
			datas[2*index+2]=data;
		}
	}

	//判断是否为空
	public boolean isEmpty(){
		return datas[0]==null;
	}

	//返回根节点
	public T root(){
		return datas[0];
	}

	public T parent(int index){
		return (T)datas[(index-1)/2];
	}

	public T left(int index){
		if(2*index+1>=arraySize)
			throw new RuntimeException("该节点为叶子节点");
		return (T)datas[2*index+1];
	}

	public T left(int index){
		if(2*index+1>=arraySize)
			throw new RuntimeException("该节点为叶子节点");
		return (T)datas[2*index+2];
	}

	public int deep(){
		return this.deep;
	}

	public int dataIndex(T data){
		for(int i=0;i<arraySize;i++){
			if(datas[i].equals(data)){
				return i;
			}
		}
		return -1;
	}

	public String toString(){
		return Arrays.toString(datas);
	}
}
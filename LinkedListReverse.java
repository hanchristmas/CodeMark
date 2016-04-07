class Node {  
    //变量  
    private int record;  
    //指向下一个对象  
    private Node nextNode;  
  
    public Node(int record) {  
        super();  
        this.record = record;  
    }  
    public int getRecord() {  
        return record;  
    }  
    public void setRecord(int record) {  
        this.record = record;  
    }  
    public Node getNextNode() {  
        return nextNode;  
    }  
    public void setNextNode(Node nextNode) {  
        this.nextNode = nextNode;  
    }  
}  
public class LinkedReverse {  
	
	//递归实现
    public static Node reverse(Node head){
    	if(head==null||head.getNextNode()==null)
    		return head;
    	Node reHead=reverse(head.getNextNode());
    	head.getNextNode().setNextNode(head);
    	head.setNextNode(null);
    	return reHead;
    }
    
    public static void main(String[] args) {  
    	Node head = new Node(0);  
        Node tmp = null;  
        Node cur = null;  
        // 构造一个长度为10的链表，保存头节点对象head     
        for (int i = 1; i < 10; i++) {  
            tmp = new Node(i);  
            if (1 == i) {  
                head.setNextNode(tmp);  
            } else {  
                cur.setNextNode(tmp);  
            }  
            cur = tmp;  
        }  
        //打印反转前的链表  
        Node h = head;  
        while (null != h) {  
            System.out.print(h.getRecord() + " ");  
            h = h.getNextNode();  
        }  
        //调用反转方法  
        head = reverse(head);  
        System.out.println("\n**************************");  
        //打印反转后的结果  
        while (null != head) {  
            System.out.print(head.getRecord() + " ");  
            head = head.getNextNode();  
        }  
    }  
}  
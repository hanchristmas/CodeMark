import java.util.Stack;
import java.util.Arrays;
public class Solution {
/*���ø���ջ�洢min�Ĵ�С���Զ�����ջ�ṹ
*/
    private int size;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<Integer>();
    private Integer[] elements = new Integer[16];
     
    public void push(int node) {
        ensureCapacity(size+1);
        elements[size++] = node;
        if(node <= min){
            minStack.push(node);
            min = minStack.peek();
        }else{
            minStack.push(min);
        }
    }
  
    private void ensureCapacity(int size) {
        // TODO Auto-generated method stub
        int len = elements.length;
        if(size > len*0.75){
            int newLen = len*2; //ÿ�����ݷ�ʽ
            elements = Arrays.copyOf(elements, newLen);
        }
    }
    public void pop() {
        Integer top = top();
        if(top != null){
            elements[size-1] = (Integer) null;
        }
        size--;
        minStack.pop();   
        min = minStack.peek();
    }
  
    public int top() {
        if(!empty()){
            if(size-1>=0)
                return elements[size-1];
        }
        return (Integer) null;
    }
    public boolean empty(){
        return size == 0;
    }
  
    public int min() {
        return min;
    }
}
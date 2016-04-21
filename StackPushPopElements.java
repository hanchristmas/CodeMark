//模拟栈的压入弹出过程，每压入一个元素，判断是否匹配；
//若匹配：弹出，判断下一个是否匹配；
//若不匹配：压入，判断；
//知道全部压入，判断栈是否为空。

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      if(popA.length==0) return false;
      //元素必须为引用类型
      Stack<Integer> stackA=new Stack<Integer>();
      for(int i=0,j=0;i<pushA.length;){
          stackA.push(pushA[i++]);
          while((j<popA.length)&&(stackA.peek()==popA[j])){
              stackA.pop();
              j++;
          }
      }
        return stackA.empty();
    }
}


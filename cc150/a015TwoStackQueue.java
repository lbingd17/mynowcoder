//push 正常push
//pop s2不为空，则pop返回；s2为空，则将s1pop的呀如s2


import java.util.Stack;
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(new Integer(node));
    }
    
    public int pop() {
      if(stack2.isEmpty()){
        while(!stack1.isEmpty()){
          stack2.push(stack1.pop());
        }
      }
      return stack2.pop().intValue();
    }
} 

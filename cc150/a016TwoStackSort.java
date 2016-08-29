import java.util.*;

public class TwoStacks {
  public ArrayList<Integer> twoStacksSort(int[] numbers) {
      /*
       * 思路：
       * 只用两个栈排序，一个是有序的asc，另一个是无序的buffer就可以实现对一个栈的排序。如何有序，当原始栈只有一个时就有序了
       * numbers中第一个为栈顶
       * 主要是解决buffer栈顶元素放在asc的位置
       * 1. buffer栈顶大于等于asc栈顶或asc空
       *  直接放
       * 2. buffer栈顶小于asc栈顶
       *  buffer栈顶值出栈，临时变量存放buffer栈顶值
       *  循环从asc中拿出值放到buffer直至asc空或满足1条件
       */
      if(numbers == null || numbers.length == 0){
          return null;
      }
      int length = numbers.length;
      ArrayList<Integer> res = new ArrayList<Integer>(length);
      Stack<Integer> buffer = new Stack<Integer>();
      Stack<Integer> ascStack = new Stack<Integer>();
      //初始状态，buffer中放了length-1个与numbers逆序的数串，asc只剩栈底元素
      for(int i = 0; i < length-1; i++){
          buffer.push(numbers[i]);
      }
      ascStack.push(numbers[length-1]);
      //排序
      int bufTop = 0;
      while(buffer.size() > 0){
          if(ascStack.isEmpty() || buffer.peek() >= ascStack.peek()){
              ascStack.push(buffer.pop());
          }else{
              bufTop = buffer.pop();
              int count_curBuffer = buffer.size();
              while(!ascStack.isEmpty() && bufTop < ascStack.peek()){
                  buffer.push(ascStack.pop());
              }
              ascStack.push(bufTop);
              int count_numsFromAsc = buffer.size()-count_curBuffer;
              for(int i = 0; i < count_numsFromAsc; i++){
                  ascStack.push(buffer.pop());
              }
          }
      }
      for(int i = 0; i < length; i++){
          res.add(ascStack.pop());
      }
      return res;
  }
}

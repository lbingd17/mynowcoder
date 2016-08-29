import java.util.*;

public class TwoStacks {
	 public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> stack=new ArrayList<Integer>();
        int temp,i;
        for(i=0;i<numbers.length;i++){
            temp=numbers[i];
            while(!stack.isEmpty()&&stack.get(stack.size()-1)<temp){
                numbers[i--]=stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
            }
            stack.add(temp);
        }
        return stack;
    }
}

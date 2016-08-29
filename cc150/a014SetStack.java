import java.util.*;
 //利用二维arraylist表示栈的集合
 //对于操作序列，如果push，注意是否size已经满，新建list，push进去；如果pop，注意是否为空，如果空，删除，在找最后一个
public class SetOfStacks {
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        ArrayList<ArrayList<Integer>> SetOfStacks=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inner=new ArrayList<Integer>();
        SetOfStacks.add(inner);
        for(int i=0;i<ope.length;i++)
        {
            inner=SetOfStacks.get(SetOfStacks.size()-1);
            if(ope[i][0]==1)
            {
                if(inner.size()<size)
                    inner.add(ope[i][1]);
                else
                {
                    inner=new ArrayList<Integer>();
                    inner.add(ope[i][1]);
                    SetOfStacks.add(inner);
                }
            }
            if(ope[i][0]==2)
            {
                //若stack已经为空
                if(SetOfStacks.get(0).size()==0)
                    continue;
                if(inner.size()==0)
                {
                    SetOfStacks.remove(SetOfStacks.size()-1);
                    inner=SetOfStacks.get(SetOfStacks.size()-1);
                }
                inner.remove(inner.size()-1);
            }
        }
        return SetOfStacks;
    }
}

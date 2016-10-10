import java.util.*;
 
public class CloseNumber {
    public int[] getCloseNumber(int x) {
        // write code here
        int[] res=new int[2];
        int num=getOneNum(x);
        int left=x-1;
        int right=x+1;
        while(left>0){
            if(num==getOneNum(left))
                break;
            left--;
        }
        while(true){
            if(num==getOneNum(right))
                break;
            right++;
        }
        res[0]=left;
        res[1]=right;
        return res;
    }
    public int getOneNum(int x){
        int count=0;
        while(x!=0){
            if((x & 1)==1){
                count++;
            }
            x>>=1;
        }
        return count;
    }
}

import java.util.*;

public class CloseNumber {
    public int[] getCloseNumber(int x) {
        int[] result=new int[2];
        result[1]=findNext(x);
        result[0]=findPre(x);
        return result;
    }
    
    public int findNext(int a){
      //c0是尾部0的个数， c1是0左方全为1的个数
        /*
        1,将index位p置为1；
        2,将index位从0到p-1清零
        （1,2的快速做法就是将拖尾0变为1，然后加1）
        3,将index位0到c1-2位置为1
        */
      int c0=0,c1=0;
        int temp=a;
       while((temp&1)==0&&temp!=0){
           c0++;
           temp>>=1;
       } 
        
        while((temp&1)==1){
            c1++;
            temp>>=1;
        }
        //判断是否没有更大的数
        if(c0+c1==31||c0+c1==0){
            return -1;
        }
        int p=c0+c1;//index为p的位置，此时p的位置肯定是0
        //1,2的快速版
        a+=Math.pow(2,c0);
        
        //3,将0到c1-2位置为1
        a+=Math.pow(2,c1-1)-1;
        return a;
        
    }
    
    public int findPre(int b){
        //c1是尾部1的个数，c0是尾部1左方全为0的个数
        /*
        1,将index位p清零
        2,将p右边所有的位都置为1
        (1,2的快速版本就是将拖尾1置为0，然后减1)
        3,将位0到位c0-2清零
        */
        int c1=0,c0=0;
        int temp=b;
        while((temp&1)==1){
            c1++;
            temp>>=1;
        }
        while((temp&1)==0&&temp!=0){
           c0++;
           temp>>=1;
       } 
        
      int p=c0+c1; //p位肯定为1
       //1,2
        b-=Math.pow(2,c1)-1;
        b-=1;
        b-=Math.pow(2,c0-1)-1;
        return b;
    }
}

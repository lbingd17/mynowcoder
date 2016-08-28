import java.util.*;
 
public class Zipper {
    public String zipString(String iniString) {
        char[] c = iniString.toCharArray();
        String str2 = "";
         
        for(int i=0; i<c.length-1; i++){
            int count = 1;
            int index = i;
            for(int j=i+1; j<c.length; j++){
                if(c[j] == c[i]){
                    count ++;
                    index = j;              //标记与位置i处的字符一样的最后下标
                }else{
                    break;
                }
            }
            str2 += c[i] + "" + count;      //+"" : 变为字符串
            i = index;                  //i直接跳至最后下标处,因为下个循坏前i++,所以i的实际跳转位置是index+1
        }
        return str2.length() < iniString.length() ? str2 : iniString;
    }
}

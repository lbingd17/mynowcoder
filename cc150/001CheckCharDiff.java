import java.util.*;
 
public class Different {
  public boolean checkDifferent(String str) {
        //使用异或,因为让支持ASCII所以判断下长度，长度超了，肯定重复
       if(str.length()>256)return false;
        for (int i = 0;i<str.length();i++) {
            for (int j = i+1;j<str.length();j++) {
                if ((str.charAt(i)^str.charAt(j))==0)
                    return false;
            }
        }
        return true;
    }
 
     
}

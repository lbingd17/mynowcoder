import java.util.*;
/*
题目描述

请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。

给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
测试样例：

"aeiou"

返回：True

"BarackObama"

返回：False
*/ 
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

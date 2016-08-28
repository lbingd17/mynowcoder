/**
给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。

给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
测试样例：

"This is nowcoder","is This nowcoder"

返回：true

"Here you are","Are you here"

返回：false
*/
import java.util.*;
 
public class Same {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        int lenA=stringA.length();
        int lenB=stringB.length();
        if(lenA!=lenB){
            return false;
        }else{
            int[] A=new int[256];
            int[] B=new int[256];
            for(int i=0;i<stringA.length();i++){
                A[stringA.charAt(i)]++;
            }
            for(int i=0;i<stringA.length();i++){
                B[stringB.charAt(i)]++;
            }
            for(int i=0;i<256;i++){
                if(A[i]!=B[i]){
                    return false;
                }
            }
             
        }
        return true;
    }
    //
    public boolean checkSam2(String a, String b) {
        // write code here
        if (a == null || b == null || a.length() != b.length())
            return false;
          
        int[] charSet = new int[256];
        for (int i = 0; i < a.length(); i++) {
            charSet[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            if (charSet[b.charAt(i)] <= 0)
                return false;
            charSet[b.charAt(i)]--;
        }
          
        return true;
    }
}

import java.util.*;
 
public class Reverse {
    public String reverseString(String iniString) {
        // write code here
         if(iniString.trim().length() == 0||iniString == null) {
            return  "";
        }
        StringBuilder sb = new StringBuilder("");
        for(int j=iniString.length()-1;j>=0;j--) {
            sb.append(iniString.charAt(j));
        }
        return sb.toString();
    }
}

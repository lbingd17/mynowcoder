import java.util.*;
 
public class ReverseEqual {
    public boolean checkReverseEqual(String s1, String s2) {
        // write code here
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
         
        return (s1+s1).contains(s2);
    }
}

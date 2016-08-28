import java.util.*;
 //利用正则表达式
public class Different {
    public boolean checkDifferent(String iniString) {   
      return !iniString.matches(".*(.)(.*\\1).*");
    } 
}

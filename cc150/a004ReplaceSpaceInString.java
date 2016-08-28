import java.util.*;

public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        StringBuilder x = new StringBuilder("");
        for(int i = 0; i < length; i ++){
            if(iniString.charAt(i) == ' '){// attention ' ', not " "
                x.append("%20");
            }
            else{
                x.append(iniString.charAt(i));
			}
		}
		return x.toString();
        
    }
}

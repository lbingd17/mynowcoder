import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Set<String> result = new TreeSet<String>();
         
        Scanner reader = new Scanner(System.in);
        String str = reader.next();
         
        for(int i = 0; i < str.length(); i++) {
            int count = 0;
            int[] iChar = new int[26];
            for(int j = i; j < str.length(); j++) {
                if(iChar[str.charAt(j) - 'a'] == 0) {
                    count++;
                    iChar[str.charAt(j) - 'a']++;
                }
                if(fun(count)) {
                    result.add(str.substring(i, j + 1));
                }          
            }
        }
 
        for(String strTemp : result) {
            System.out.println(strTemp);
        }
    }
     
    public static boolean fun(int count) {
        if(count == 1  || count == 2  || count == 3  || count == 5  || count == 8  ||
           count == 13 || count == 21 || count == 34 || count == 55 || count == 89) {
            return true;
        }
        else {
            return false;
        }
    }
}

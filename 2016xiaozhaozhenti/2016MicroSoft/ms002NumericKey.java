import java.util.Scanner;
 
public class Main {
    private static int T;
    private static char[] res;
     
    private static final int[][] boost = new int[][] {
            { 0 },
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 0, 2, 3, 5, 6, 8, 9 },
            { 3, 6, 9 },
            { 0, 4, 5, 6, 7, 8, 9 },
            { 0, 5, 6, 8, 9 },
            { 3, 6, 9 },
            { 0, 7, 8, 9 },
            { 0, 8, 9 },
            { 9 }
    };
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        T = scanner.nextInt();
        scanner.nextLine();
        while (--T >= 0) {
            String num = scanner.nextLine();
            char[] numArr = num.toCharArray();
            res = new char[num.length()];
            search(numArr, 0, 1, false);
            System.out.println(new String(res));
        }
    }
 
    private static boolean search(char[] numArr, int length, int n, boolean sw) {
        if(length == numArr.length)
            return true;
        int st = boost[n].length - 1;
        int nowF = numArr[length] - '0';
         
        if(sw){
            char c = (char) ('0' + boost[n][boost[n].length - 1]);
            for (int i = length; i < numArr.length; ++i) {
                res[i] = c;
            }
            return true;
        }
         
        for(int i = st;i >= 0; --i){
            if(!sw && boost[n][i] > nowF)
                continue;
            res[length] = (char) ('0' + boost[n][i]);
            if(boost[n][i] < nowF || sw){
                if(search(numArr, length + 1, boost[n][i], true))
                    return true;
            }
            else
                if(search(numArr, length + 1, boost[n][i], false))
                    return true;
                 
        }
        return false;
    }
 
}

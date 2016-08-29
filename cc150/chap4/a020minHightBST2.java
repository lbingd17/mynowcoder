import java.util.*;
 
public class MinimalBST {
    public int buildMinimalBST(int[] vals) {
        int size = vals.length;       
        return (int)(Math.log(size+1)/Math.log(2))+1;
        return (int)(Math.log(size)/Math.log(2))+1;
    }
}

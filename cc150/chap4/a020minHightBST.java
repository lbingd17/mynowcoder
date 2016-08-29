import java.util.*;
 
public class MinimalBST {
     
    public int build(int[] vals, int start, int end) {
        if (end <= start) {
            return 1;
        }
        int mid = (start + end) >> 1;
        int height1 = 1 + build(vals, start, mid - 1);
        int height2 = 1 + build(vals, mid + 1, end);
        return Math.max(height1, height2);
         
    }
     
    public int buildMinimalBST(int[] vals) {
        // write code here
        if (vals == null || vals.length < 1)
            return 0;
        return build(vals, 0, vals.length - 1);
    }
}

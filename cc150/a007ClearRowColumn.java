import java.util.*;

public class Clearer {
    public int[][] clearZero(int[][] mat, int n) {
        boolean[] rowflags = new boolean[n];
        boolean[] colflags = new boolean[n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
				if(mat[i][j] == 0){
                    rowflags[i] = true;
                    colflags[j] = true;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (rowflags[i] || colflags[j]) {
                    mat[i][j] = 0;
                }
            }
        }
 
        return mat;
        
    }
}

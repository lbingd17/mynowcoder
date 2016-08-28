import java.util.*;

public class Transform {
    public int[][] transformImage(int[][] mat, int n) {
        // write code here
        int temp;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){//第i行对应的列为第i列到第n-1-i列
                temp = mat[i][j];
                mat[i][j]=mat[n-j-1][i];
                mat[n-j-1][i]=mat[n-i-1][n-j-1];
                mat[n-i-1][n-j-1]=mat[j][n-i-1];
                mat[j][n-i-1]=temp;
            }

        }
        return mat;
    }
}

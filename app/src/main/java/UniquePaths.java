import java.util.*;

public class UniquePaths {
    public static void main(String arg[]){
        UniquePaths u=new UniquePaths();
        System.out.println(u.uniquePaths(4,5));
    }
    public int uniquePaths(int m, int n) {
        int matrix[][]=new int[2][n];
        for(int i=0;i<n;i++){
            matrix[0][i]=1;
        }
        int c=1;
        for(int i=1;i<m;i++){
            matrix[c][0]=1;
            for(int j=1;j<n;j++){
                matrix[c][j]=matrix[1-c][j]+ matrix[c][j-1];
            }
            c=(c+1)%2;
        }
        return matrix[1-c][n-1];
    }
}

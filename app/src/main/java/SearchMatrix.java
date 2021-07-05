import java.util.Arrays;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix[0][0]>target){
            return false;
        }
        int i=0,j=matrix.length-1,mid;
        while(i<j){
            mid=(i+j)/2;
            if(matrix[mid][0]==target){
                i=mid;
                return true;
            }else if(matrix[mid][0]<target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        if(matrix[i][0]>target){
            i--;
        }
        j= Arrays.binarySearch(matrix[i], target);
        if(j>=0){
            return true;
        }else{
            return false;
        }
    }
}

public class MinPathSum {
	public static void main(String argc[]){
		MinPathSum s=new MinPathSum();
		s.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
	}
    public int minPathSum(int[][] grid) {
    	int m=grid.length,n=grid[0].length;
        for(int i=1;i<n;i++){
        	grid[0][i]+=grid[0][i-1];
        }
        for(int i=1;i<m;i++){
        	int t[]=grid[i];
        	t[0]+=grid[i-1][0];
            for(int j=1;j<n;j++){
            	if(grid[i-1][j]<grid[i][j-1]){
            		t[j]+=grid[i-1][j];
            	}else{
            		t[j]+=t[j-1];
            	}
            }
        }
        return grid[m-1][n-1];
    }
}

public class NumIslands {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        boolean[][] flag=new boolean[grid.length][grid[0].length];
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(flag[i][j]==false&&grid[i][j]=='1'){
                    num++;
                    traversal(grid,flag,i,j);
                }
            }
        }
        return num;
    }
    public void traversal(char[][] grid,boolean[][] flag,int i,int j){
        flag[i][j]=true;
        if(i+1< grid.length&&grid[i+1][j]=='1'&&flag[i+1][j]==false){
            traversal(grid,flag,i+1,j);
        }
        if(i-1>=0&&grid[i-1][j]=='1'&&flag[i-1][j]==false){
            traversal(grid,flag,i-1,j);
        }
        if(j+1< grid[0].length&&grid[i][j+1]=='1'&&flag[i][j+1]==false){
            traversal(grid,flag,i,j+1);
        }

        if(j-1>=0&&grid[i][j-1]=='1'&&flag[i][j-1]==false){
            traversal(grid,flag,i,j-1);
        }
    }
}

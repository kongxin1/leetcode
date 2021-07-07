public class UniquePathsWithObstacles {
    public static void main(String arg[]) {
        UniquePathsWithObstacles u = new UniquePathsWithObstacles();
        int[][] o = new int[][]{{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(u.uniquePathsWithObstacles(o));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int matrix[][] = new int[2][n];
        matrix[0][0]=1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0)
                matrix[0][i] = matrix[0][i-1];
        }
        int c = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                matrix[c][0] = matrix[1 - c][0];
            } else {
                matrix[c][0] = 0;
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    matrix[c][j] = matrix[1 - c][j] + matrix[c][j - 1];
                } else {
                    matrix[c][j] = 0;
                }
            }
            c = (c + 1) % 2;
        }
        return matrix[1 - c][n - 1];
    }
}

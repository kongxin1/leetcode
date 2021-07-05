public class SetZeroes {
    public static void main(String[] args) throws Exception {
        SetZeroes code = new SetZeroes();
        int[][] s = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        code.setZeroes(s);
    }

    public void setZeroes(int[][] matrix) {
        boolean flag=true;
        boolean row=false,column=false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    flag=false;
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                    if(i==0){
                        row=true;
                    }
                    if(j==0){
                        column=true;
                    }
                }
            }
        }
        if (flag) {
            return;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0]==0||matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        if(row){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }
        if(column){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
    }
}

public class SetZeroes {
    public static void main(String[] args) throws Exception {
        SetZeroes code = new SetZeroes();
        int[][] s = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        code.setZeroes(s);
    }

    public void setZeroes(int[][] matrix) {
        byte[] row=new byte[25];
        byte[] column=new byte[25];
        boolean flag=true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    flag=false;
                    row[i>>3]=(byte)(row[i>>3] | 1<<(i&7));
                    column[j>>3]=(byte)(column[j>>3] | 1<<(j&7));
                }
            }
        }
        if (flag) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((row[i>>3]&(1<<(i&7)))!=0) {
                    matrix[i][j]=0;
                }else if ((column[j>>3]&(1<<(j&7)))!=0) {
                    matrix[i][j]=0;
                }
            }
        }
    }
}

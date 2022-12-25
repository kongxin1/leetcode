public class FindDiagonalOrder {
    public static void main(String[] args) {
        FindDiagonalOrder f=new FindDiagonalOrder();
        f.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int i=0,j=0,m=0;
        boolean up=true;
        int[] res=new int[mat.length*mat[0].length];
        while(true){
            res[m++]=mat[i][j];
            if(up){
                if(i-1>=0&&j+1<mat[0].length){
                    i--;j++;
                }else if(j+1<mat[0].length){
                    j++;
                    up=false;
                }else{
                    i++;
                    up=false;
                }
            }else{
                if(i+1<mat.length&&j-1>=0){
                    i++;j--;
                }else if(i+1<mat.length){
                    i++;
                    up=true;
                }else{
                    j++;
                    up=true;
                }
            }
            if(i<0||i>=mat.length){
                break;
            }
            if(j<0||j>=mat[0].length){
                break;
            }
        }
        return res;
    }
}

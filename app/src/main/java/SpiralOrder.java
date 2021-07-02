import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args)throws Exception {
        int[][] matrix =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        SpiralOrder rotate=new SpiralOrder();
        rotate.spiralOrder(matrix).stream().forEach(System.out::print);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int[][] f=new int[4][2];
        f[0][0]=0;f[0][1]=0;
        f[1][0]=0;f[1][1]= matrix[0].length-1;
        f[2][0]= matrix.length-1;f[2][1]=0;
        f[3][0]= matrix.length-1;f[3][1]= matrix[0].length-1;

        while(true){
            if(f[2][0]<f[0][0]||f[1][1]<f[0][1]){
                break;
            }
            for(int a=f[0][0];a<=f[1][1];a++){
                res.add(matrix[f[0][0]][a]);
            }
            if(f[1][0]>=f[3][0]){
                break;
            }
            for(int a=f[1][0]+1;a<=f[3][0];a++){
                res.add(matrix[a][f[1][1]]);
            }
            for(int a=f[3][1]-1;a>=f[2][1];a--){
                res.add(matrix[f[3][0]][a]);
            }
            if(f[3][1]<=f[2][1]){
                break;
            }
            for(int a=f[2][0]-1;a>f[0][0];a--){
                res.add(matrix[a][f[0][1]]);
            }
            f[0][0]++;f[0][1]++;
            f[1][0]++;f[1][1]--;
            f[2][0]--;f[2][1]++;
            f[3][0]--;f[3][1]--;

        }
        return res;
    }
}

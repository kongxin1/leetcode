public class Rotate {
	public static void main(String argc[]){
		int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		Rotate r=new Rotate();
		r.rotate(matrix);
	}
	public void rotate(int[][] matrix) {
		if(matrix.length==1){
			return ;
		}
		 int[] f=new int[4];
		 int l=matrix.length-1;
		 //横
		 f[0]=0;f[1]=l;
		 //竖
		 f[2]=0;f[3]=l;
		 int j,k;
		 while(true){
			 for(int i=0;i<f[1]-f[0];i++){
				 j=f[0]+i;k=f[3];
				 int m=matrix[j][k];
				 matrix[j][k]=matrix[f[0]][f[2]+i];
				 
				 j=f[1];k=f[3]-i;
				 int n=m;
				 m=matrix[j][k];
				 matrix[j][k]=n;
				 
				 j=f[1]-i;k=f[2];
				 n=matrix[j][k];
				 matrix[j][k]=m;
				 
				 j=f[0];k=f[2]+i;
				 matrix[j][k]=n;
			 }
			 
			 f[0]++;f[1]--;f[2]++;f[3]--;
			 if(f[0]>=f[1]){
				 break;
			 }
		 }
	}
}

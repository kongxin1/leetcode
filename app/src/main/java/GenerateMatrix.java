public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int i=1,c=0;
        int max=n*n;

        while(true){
            for(int j=c ;  i<=max&& j<=n-(c+1) ;i++,j++){
                res[c][j]=i;
            }

            for(int j=c+1;j<n-c && i<=max;j++,i++){
                res[j][n-c-1]=i;
            }
            for(int j=n-c-2;j>=c&& i<=max;j--,i++){
                res[n-c-1][j]=i;
            }
            for(int j=n-c-2;j>=c+1&&i<=max;j--,i++){
                res[j][c]=i;
            }
            c++;
            if(i>max){
                break;
            }
        }
        return res;
    }
}

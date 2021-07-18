public class Exist {
    public static void main(String[] args) {
        Exist e=new Exist();
        System.out.print(e.exist(
                new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
                "ABCCED"));
    }
    public boolean exist(char[][] board, String word) {
        int m= board.length,n=board[0].length;
        boolean flag[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board,flag,i,j,word,1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board,boolean[][] flag,int i,int j,String word,int index){
        if(index==word.length()){
            return true;
        }
        flag[i][j]=true;
        //向前
        if(i+1< board.length&&!flag[i+1][j]&&word.charAt(index)==board[i+1][j]){
            if(search(board,flag,i+1,j,word,index+1))
                return true;
        }
        //向后
        if(i-1>=0&&!flag[i-1][j]&&word.charAt(index)==board[i-1][j]){
            if(search(board,flag,i-1,j,word,index+1))
                return true;
        }
        //向下
        if(j+1<board[0].length&&!flag[i][j+1]&&word.charAt(index)==board[i][j+1]){
            if(search(board,flag,i,j+1,word,index+1))
                return true;
        }
        //向上
        if(j-1>=0&&!flag[i][j-1]&&word.charAt(index)==board[i][j-1]){
            if(search(board,flag,i,j-1,word,index+1))
                return true;
        }
        flag[i][j]=false;
        return false;
    }
}

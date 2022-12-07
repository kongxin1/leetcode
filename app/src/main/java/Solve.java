public class Solve {
    public static void main(String argv[]){
        Solve s=new Solve();
        char[][] board=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        s.solve(board);
    }
    public void solve(char[][] board) {
        boolean[][] matrix=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'&&!matrix[i][0]){
                update(board,matrix,i,0);
            }
            if(board[i][board[0].length-1]=='O'&&!matrix[i][board[0].length-1]){
                update(board,matrix,i,board[0].length-1);
            }
        }

        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'&&!matrix[0][i]){
                update(board,matrix,0,i);
            }
            if(board[board.length-1][i]=='O'&&!matrix[board.length-1][i]){
                update(board,matrix,board.length-1,i);
            }
        }
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                if(board[i][j]=='O'&&matrix[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
    }
    public void update(char[][] board , boolean[][] matrix,int i,int j){
        matrix[i][j]=true;
        if(i+1<board.length&&!matrix[i+1][j]&&board[i+1][j]=='O'){
            update(board,matrix,i+1,j);
        }
        if(j+1<board[0].length&&!matrix[i][j+1]&&board[i][j+1]=='O'){
            update(board,matrix,i,j+1);
        }
        if(i-1>=0&&!matrix[i-1][j]&&board[i-1][j]=='O'){
            update(board,matrix,i-1,j);
        }
        if(j-1>=0&&!matrix[i][j-1]&&board[i][j-1]=='O'){
            update(board,matrix,i,j-1);
        }
    }
}

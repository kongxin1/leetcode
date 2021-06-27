import java.util.Arrays;
import java.util.Scanner;

public class IsValidSudoku {
    public static void main(String[] args)throws Exception {
        IsValidSudoku code=new IsValidSudoku();
        Scanner sc = new Scanner(System.in);
        while(true) {
            char[][] c=new char[9][9];
            for(int i=0;i<9;i++){
                String l = sc.nextLine();
                Character[] ct=Arrays.stream(l.split(",")).map(x->x.charAt(0)).toArray(Character[]::new);
                char[] t=new char[9];
                for(int j=0;j<9;j++){
                    t[j]=ct[j];
                }
                c[i]=t;
            }

            System.out.println(code.isValidSudoku(c));
        }
    }
    public boolean isValidSudoku(char[][] board) {
        int b[]=new int[]{1,1,1,1,1,1,1,1,1,1};
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.'){
                    int t=--b[board[i][j]-'0'];
                    if(t<0){
                        return false;
                    }
                }
            }
            init(b);
        }


        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++) {
                if(board[j][i]!='.'){
                    int t=--b[board[j][i]-'0'];
                    if(t<0){
                        return false;
                    }
                }
            }
            init(b);
        }

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3) {
                if(!judge(i,j,board,b)){
                    return false;
                }
                init(b);
            }
            init(b);
        }
        return true;
    }
    public void init(int[] b) {
        for(int i=0;i<10;i++){
            b[i]=1;
        }
    }
    public boolean judge(int i,int j,char[][] board,int b[]){
        for(int s=i;s<i+3;s++){
            for(int e=j;e<j+3;e++){
                if(board[s][e]!='.'){
                    int t=--b[board[s][e]-'0'];
                    if(t<0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

public class IsThree {
    public static void main(String argv[]){
        IsThree i=new IsThree();
        i.isThree(9);
    }
    public boolean isThree(int n) {
        if(n<=3){
            return false;
        }
        int t=(int)Math.sqrt(n);
        for(int i=2;i<=t;i++){
            if(n%i==0){
                if(n/i==i){
                    return true;
                }else{
                    return false;
                }

            }
        }
        return false;
    }
}

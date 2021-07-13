public class NumDecodings {
    public static void main(String[] args)throws Exception {
        NumDecodings n=new NumDecodings();
        n.numDecodings("301");
    }
    public int numDecodings(String s) {
        int length=s.length();
        if(s.charAt(0)=='0'){
            return 0;
        }
        if(length==1){
            return 1;
        }

        int cnt[]= new int[length];
        cnt[0]=1;
        char first=s.charAt(0),second=s.charAt(1);
        if(second=='0'&&first>='3'){
            return 0;
        }else if(second=='0'&&(first=='1'||first=='2')){
            cnt[1]=1;
        }else if(first>='3'){
            cnt[1]=1;
        }else if(first=='2'&&second>'6'){
            cnt[1]=1;
        }else{
            cnt[1]=2;
        }
        for(int i=2;i<length;i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    cnt[i]=cnt[i-2];
                }else{
                    return 0;
                }
            }else if(s.charAt(i)>='1'&&s.charAt(i)<='6'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    cnt[i]=cnt[i-1]+cnt[i-2];
                }else{
                    cnt[i]=cnt[i-1];
                }
            }else{
                if(s.charAt(i-1)=='1'){
                    cnt[i]=cnt[i-1]+cnt[i-2];
                }else{
                    cnt[i]=cnt[i-1];
                }
            }
        }
        return cnt[length-1];
    }
}

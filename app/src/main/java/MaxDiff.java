public class MaxDiff {
    public int maxDiff(int num) {
        int b[]=new int[10];
        int t=num;
        int length=0;
        while(t!=0){
            b[length++]=t%10;
            t=t/10;
        }
        int max=9,min=1;
        int changeMax=-1,changeMin=-1;
        if(b[length-1]==1){
            for(int i=length-2;i>=0;i--){
                if(b[i]!=1&&b[i]!=0){
                    changeMin=b[i];
                    break;
                }
            }
        }else if(b[length-1]==9){
            for(int i=length-2;i>=0;i--){
                if(b[i]!=9){
                    changeMax=b[i];
                    break;
                }
            }
        }
        for(int i=length-2;i>=0;i--){
            if(b[i]==changeMin){
                min=min*10;
            }else if(b[length-1]==b[i] && b[length-1]!=1){
                min=min*10+1;
            }else{
                min=min*10+b[i];
            }

            if(b[i]==changeMax){
                max=max*10+9;
            }else if(b[length-1]==b[i] && b[length-1]!=9){
                max=max*10+9;
            }else{
                max=max*10+b[i];
            }
        }
        return max-min;
    }
}

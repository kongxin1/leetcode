public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct m=new MaxProduct();
        m.maxProduct(new int[]{2,-5,-2,-4,3});
    }
    public int maxProduct(int[] nums) {
        int[] multi=new int[nums.length];
        multi[0]=nums[0];
        int res=multi[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0&&multi[i-1]>0){
                multi[i]=nums[i]*multi[i-1];
            }else if(nums[i]>0&&multi[i-1]<=0){
                multi[i]=nums[i];
            }else if(nums[i]==0){
                multi[i]=nums[i];
            }else if(nums[i]<0){
                int zero=-1, negt=-1;
                for(int j=i-1;j>=0;j--){
                    if(zero==-1&&nums[j]==0){
                        zero=j;
                    }
                    if(negt==-1&&nums[j]<0){
                        negt=j;
                    }
                    if(zero!=-1&&negt!=-1){
                        break;
                    }
                }
                if(negt==-1&&zero!=-1){
                    multi[i]=0;
                }else if(negt!=-1&&zero<negt){
                    if(negt-1>=0&&multi[negt - 1]>0) {
                        multi[i] = multi[negt - 1] * nums[negt] * nums[i] ;
                    }else {
                        multi[i] = nums[negt] * nums[i] ;
                    }
                    for(int j=i-1;j>negt;j--){
                        multi[i]*= nums[j];
                    }
                }else if(negt==-1&&zero==-1){
                    multi[i]=nums[i];
                }else if(negt!=-1&&zero>negt){
                    multi[i]=0;
                }
            }
            if(res< multi[i]){
                res= multi[i];
            }
        }
        return res;
    }
}

public class Rotate2 {
    public static void main(String[] args) {
        Rotate2 r=new Rotate2();
        r.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
    public void rotate(int[] nums, int k) {
        k=k% nums.length;
        int m,n;
        boolean flag[]=new boolean[nums.length];
        for(int i=0;i< k;i++){
            if(flag[i]==false){
                int j=(i+k)% nums.length;
                m=nums[i];
                while(flag[j]==false){
                    n=nums[j];
                    nums[j]=m;
                    m=n;
                    flag[j]=true;
                    j=(j+k)% nums.length;
                }
            }
        }
    }
}

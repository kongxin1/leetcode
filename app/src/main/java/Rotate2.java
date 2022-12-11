public class Rotate2 {
    public static void main(String[] args) {
        Rotate2 r=new Rotate2();
        r.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
    public void rotate(int[] nums, int k) {
        k=k% nums.length;
        int m=nums[0];
        int n=nums[0];
        boolean flag[]=new boolean[nums.length];
        for(int i=0;i< nums.length;i++){
            if(flag[i]==false){
                int j=i;
                m=nums[i];
                while(flag[(j+k)% nums.length]==false){
                    int next=(j+k)% nums.length;
                    n=nums[next];
                    nums[next]=m;
                    m=n;
                    flag[next]=true;
                    j=next;
                }
            }
        }
    }
}

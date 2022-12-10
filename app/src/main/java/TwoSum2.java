public class TwoSum2 {
    public static void main(String[] args) {
        TwoSum2 t=new TwoSum2();
        t.twoSum(new int[]{2,7,11,15},9);
    }
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j= numbers.length-1;
        int[] res=new int[2];
        while(i<j){
            if(numbers[i]+numbers[j]>target){
                j--;
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else{
                res[0]=i+1;
                res[1]=j+1;
                break;
            }
        }
        return res;
    }
}

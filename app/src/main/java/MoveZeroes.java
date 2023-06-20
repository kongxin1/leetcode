public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        m.moveZeroes(new int[]{0,1,0,3,12});
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int s = 0, e = 1;
        while (e < nums.length) {
            if (nums[s] == 0) {
                while (e < nums.length) {
                    if (nums[e] == 0) {
                        e++;
                    } else {
                        break;
                    }
                }
                if (e == nums.length) {
                    return;
                }
                nums[s++] = nums[e];
                nums[e++] = 0;
            } else {
                s++;
                if(s==e){
                    e=s+1;
                }
            }
        }
    }
}

import java.util.*;

/**
 * 179. 最大数
 * 执行结果：通过
 * 显示详情
 * 执行用时：6 ms, 在所有 Java 提交中击败了90.34%的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了90.73%的用户
 */
public class LargestNumber {
    public static void main(String[] args)throws Exception {
        LargestNumber code=new LargestNumber();
        Scanner sc = new Scanner(System.in);
        List<Integer> list=new ArrayList<Integer>();
        while(true) {
            String line = sc.nextLine();
            String[] l=line.split(",");
            int[] nums=new int[l.length];
            for(int i=0;i<l.length;i++){
                nums[i]=Integer.valueOf(l[i]);
            }
            System.out.println(code.largestNumber(nums));
        }
    }
    public String largestNumber(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        String[] num = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(num, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.equals(s2)) {
                    return 0;
                }
                String t1=s1+s2;
                String t2=s2+s1;
                if(t1.compareTo(t2)>0){
                    return 1;
                }else if(t1.compareTo(t2)<0){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        StringBuilder res = new StringBuilder();
        for (int i = num.length - 1; i >= 0; i--) {
            res.append(num[i]);
        }
        if(res.charAt(0)=='0'){
            return "0";
        }
        return res.toString();
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 *
 * 执行用时：2 ms , 在所有 Java 提交中击败了 99.49% 的用户
 * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 81.98% 的用户
 */
public class MaxArea {
    public static void main(String[] args)throws Exception {
        MaxArea maxArea=new MaxArea();
        Scanner sc = new Scanner(System.in);
        List<Integer> list=new ArrayList<Integer>();
        while(true) {

            String line = sc.nextLine();

            String[] areaArray=line.split(",");
            int[] height=new int[areaArray.length];
            for(int j=0;j<areaArray.length;j++){
                height[j]=Integer.valueOf(areaArray[j]);
            }
            maxArea.maxArea(height);
        }
    }
    public int maxArea(int[] height) {
        int s=0,e=height.length-1;
        int max=-1;
        int t=0;
        while(s<e) {
            if (height[s] <height[e]){
                t=(e-s)*height[s];
                s++;
            }else if(height[s] >height[e]){
                t=(e-s)*height[e];
                e--;
            }else{
                t=(e-s)*height[e];
                e--;s++;
            }
            if(max<t){
                max=t;
            }
        }
        return max;
    }
}

import java.util.Scanner;

/**
 * 134. 加油站
 * 在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了72.53%的用户
 */
public class CanCompleteCircuit {
    public static void main(String[] args)throws Exception {
        CanCompleteCircuit code=new CanCompleteCircuit();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            String[] gas=line.split(",");
            line = sc.nextLine();
            String[] cost=line.split(",");
            int[] gasi=new int[gas.length];
            int[] costi=new int[cost.length];
            for(int i=0;i<gasi.length;i++){
                gasi[i]=Integer.valueOf(gas[i]);
                costi[i]=Integer.valueOf(cost[i]);
            }
            System.out.println(code.canCompleteCircuit(gasi,costi));
        }
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            gas[i]-=cost[i];
        }
        int j=0;
        cost[j]=0;
        int t=0;
        for(int i=0;i<gas.length;i++){
            cost[j]=cost[j]+gas[i];
            if(cost[j]<0){
                j++;
                if(j>=gas.length){
                    return -1;
                }
                cost[j]=0;
                t=i+1;
            }
        }
        if(t==gas.length){
            return -1;
        }
        for(int i=0;i<j;i++){
            cost[j]+=cost[i];
        }
        if(cost[j]>=0) {
            return t;
        }else{
            return -1;
        }
    }
}

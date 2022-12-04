public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit m=new MaxProfit();
        int[] prices=new int[]{7,6,4,3,1};
        System.out.print(m.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int res=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[i-1]){
                res+=(prices[i-1]-min);
                min=prices[i];
                continue;
            }
            if(i==prices.length-1){
                res+=prices[i]-min;
            }
        }
        return res;
    }
}

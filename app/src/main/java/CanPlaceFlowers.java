/**
 * 功能描述
 *
 * @author: 孔新
 * @date: 2023年08月26日 20:52
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        CanPlaceFlowers CanPlaceFlowers=new CanPlaceFlowers();
        CanPlaceFlowers.canPlaceFlowers(new int[]{0,1,0,0,1},1);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i< flowerbed.length&&n>0;i++){
            if(flowerbed[i]!=1){
                if((i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)){
                    flowerbed[i]=1;
                    n--;
                }
            }

        }
        if(n==0){
            return true;
        }else{
            return false;
        }
    }
}

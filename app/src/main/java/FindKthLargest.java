public class FindKthLargest {
    public static void main(String[] args)throws Exception {
        FindKthLargest f=new FindKthLargest();
        f.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);
    }
    public int findKthLargest(int[] nums, int k) {
        //构建小顶堆
        for(int i=(k-1)/2;i>=0;i--){
            maxHeapify(nums,i,k-1);
        }
        for(int i=k;i< nums.length;i++){
            if(nums[i]>nums[0]){
                nums[0]=nums[i];
                maxHeapify(nums,0,k-1);
            }
        }
        return nums[0];
    }
    private void maxHeapify(int[] heap,int index,int len){
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。

        if(li > len) return;       // 左子节点索引超出计算范围，直接返回。
        if(ri <= len && heap[ri] < heap[li]) // 先判断左右子节点，哪个较大。
            cMax = ri;
        if(heap[cMax] < heap[index]){
            swap(heap,cMax, index);      // 如果父节点被子节点调换，
            maxHeapify(heap,cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }
    private void swap(int[] heap,int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

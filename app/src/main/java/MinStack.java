public class MinStack {
    int[] list;
    int min;
    int index;
    public MinStack() {
        list=new int[30001];
        min=Integer.MIN_VALUE;
        index=-1;
    }

    public void push(int val) {
        if(index==-1){
            min=val;
        }
        if(min>val){
            min=val;
        }
        index++;
        list[index]=val;
    }

    public void pop() {
        if(min==list[index]){
            min=Integer.MAX_VALUE;
            for(int i=0;i<index;i++){
                if(min>list[i]){
                    min=list[i];
                }
            }
        }
        index--;
    }

    public int top() {
        return list[index];
    }

    public int getMin() {
        return min;
    }
}

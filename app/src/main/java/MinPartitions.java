public class MinPartitions {
    public static void main(String[] args) {
        MinPartitions m=new MinPartitions();
        m.minPartitions("82734");
    }
    public int minPartitions(String n) {
        int m='0';
        int lenght=n.length();
        for(int i=0;i<lenght;i++){
            char c=n.charAt(i);
            if(m<c){
                m=c;
                if(m=='9'){
                    return 9;
                }
            }
        }
        return m-'0';
    }
}

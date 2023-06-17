public class Compress {
    public static void main(String[] args) {
        Compress c=new Compress();
        System.out.println(c.compress(new char[]{'a'}));
    }
    public int compress(char[] chars) {
        int t=1,i=0,j=1;
        for(;j<chars.length;j++){
            if(chars[j]== chars[i]){
                t++;
            }else{
                i+=retBit(t,chars,i);
                t=1;
                chars[++i]=chars[j];
            }
        }
        i+=retBit(t,chars,i);
        return i+1;
    }
    public int retBit(int t,char[] chars,int i){
        if(t==1){
            return 0;
        }
        if(t<10){
            chars[++i]=(char)('0'+t);
            return 1;
        }
        if(t<100){
            chars[++i]=(char)(t/10+'0');
            chars[++i]=(char)(t%10+'0');
            return 2;
        }
        if(t<1000){
            chars[++i]=(char)(t/100+'0');
            chars[++i]=(char)(t/10%10+'0');
            chars[++i]=(char)(t%10+'0');
            return 3;
        }else {
            chars[++i]=(char)(t/1000+'0');
            chars[++i]=(char)(t/100%10+'0');
            chars[++i]=(char)(t/10%10+'0');
            chars[++i]=(char)(t%10+'0');
            return  4;
        }
    }
}

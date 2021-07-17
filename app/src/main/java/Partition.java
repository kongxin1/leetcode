import java.util.*;

public class Partition {
    public static void main(String[] args){
        Partition p=new Partition();
        p.partition("abbba");
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        splitString(res,new ArrayList<>(),s,0);
        return res;
    }
    public void splitString(List<List<String>> res,List<String> list,String s,int index){
        if(index==s.length()){
            List<String> t=new ArrayList<>(list.size());
            list.forEach(x->{t.add(x);});
            res.add(t);
            return;
        }
        for(int i=s.length()-1;i>=index;i--){
            if(i==index){
                list.add(s.substring(i,i+1));
                splitString(res,list,s,index+1);
                list.remove(list.size()-1);
            }else{
                if(s.charAt(i)==s.charAt(index)){
                    if(i-1==index||i-2==index){
                        list.add(s.substring(index,i+1));
                        splitString(res,list,s,i+1);
                        list.remove(list.size()-1);
                    }
                    else if(check(s,index,i)){
                        list.add(s.substring(index,i+1));
                        splitString(res,list,s,i+1);
                        list.remove(list.size()-1);
                    }
                }
            }
        }
    }
    public boolean check(String str,int s,int e){
        int length=(e+1-s)/2+s;
        for(int i=s+1;i<length;i++){
            if(str.charAt(i)!=str.charAt(e-(i-s))){
                return false;
            }
        }
        return true;
    }
}

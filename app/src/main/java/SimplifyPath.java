import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder res=new StringBuilder();
        String[] paths=path.split("/");
        LinkedList<String> stack=new LinkedList<String>();
        for(int i=1;i<paths.length;i++){
            if(paths[i].equals(".")||paths[i].equals("")){
                continue;
            }else if(paths[i].equals("..")){
                if(stack.size()!=0){
                    stack.pop();
                }
            }else{
                stack.push(paths[i]);
            }
        }
        int size=stack.size();
        for(int i=0;i<size;i++){
            res.append("/");
            res.append(stack.pollLast());
        }
        if(res.length()==0){
            res.append("/");
        }
        return res.toString();
    }
}

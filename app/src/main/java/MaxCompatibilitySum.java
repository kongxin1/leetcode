public class MaxCompatibilitySum {
    public static void main(String argv[]){
        MaxCompatibilitySum m=new MaxCompatibilitySum();
        System.out.println(m.maxCompatibilitySum(new int[][]{{1,1,0},{1,0,1},{0,0,1}},new int[][]{{1,0,0},{0,0,1},{1,1,0}}));
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return search(students,mentors,new boolean[students.length],0,0);
    }
    public int search(int[][] students, int[][] mentors,boolean[] flag,int index,int sum){
        if(index==students.length){
            return sum;
        }
        int max=0;
        for(int i=0;i<students.length;i++){
            if(flag[i]==true){
                continue;
            }
            flag[i]=true;
            int s=0;
            for(int j=0;j<students[0].length;j++){
                if(students[index][j]==mentors[i][j]){
                    s++;
                }
            }
            int t=search(students,mentors,flag,index+1,sum+s);
            if(max<t){
                max=t;
            }
            flag[i]=false;
        }
        return max;
    }
}

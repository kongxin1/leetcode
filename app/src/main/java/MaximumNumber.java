public class MaximumNumber {
    public static void main(String argv[]) {
        MaximumNumber m=new MaximumNumber();
        m.maximumNumber("021",new int[]{9,4,3,5,7,2,1,9,0,6});
    }

    public String maximumNumber(String num, int[] change) {
        StringBuilder res = new StringBuilder(num);
        for (int i = 0; i < num.length(); i++) {
            int c = res.charAt(i) - '0';
            if (change[c] > c) {
                res.setCharAt(i, (char) ('0' + change[c]));
                for (int j = i + 1; j < num.length(); j++) {
                    c = res.charAt(j) - '0';
                    if (change[c] < c) {
                        break;
                    }
                    res.setCharAt(j,(char)('0'+change[c]));
                }
                break;
            }
        }
        return res.toString();
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HIndex {
    public static void main(String argv[]) {
        HIndex h = new HIndex();
        System.out.print(h.hIndex(new int[]{1, 1}));
    }

    public int hIndex(int[] citations) {
        int[] cnt = new int[citations.length + 1];

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length) {
                cnt[citations.length]++;
            } else {
                cnt[citations[i]]++;
            }
        }
        int res = 0;
        for (int i = citations.length; i >= 0; i--) {

            res += cnt[i];
            if (res >= i) {
                return i;
            }

        }
        return 0;
    }
}

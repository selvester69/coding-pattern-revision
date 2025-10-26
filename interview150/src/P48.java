import java.util.ArrayList;
import java.util.List;

public class P48 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        for (int i = 0; i < nums.length-1; i++) {
            int j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] > 1) {
                    break;
                }
            }
            if (nums[i] != nums[j-1]) {
                res.add(new String(nums[i] + "->" + nums[j-1]));
                i = j-1;
            }
        }

        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[] { 0, 1, 2, 4, 5, 7,8 }));
    }
}

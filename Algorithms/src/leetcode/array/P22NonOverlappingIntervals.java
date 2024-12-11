package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P22NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (res.size()>0 && res.get(res.size() - 1)[1] > intervals[i][0]) {
                if(res.get(res.size() - 1)[1]> intervals[i][1]){
                    res.remove(res.size() - 1);
                    res.add(intervals[i]);
                }
            } else {
                System.out.println(intervals[i][0] + " " + intervals[i][1]);
                res.add(intervals[i]);
            }
        }
        return intervals.length - res.size();
    }
}

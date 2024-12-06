package leetcode.array;
import java.util.*;
public class P08InsertInterval {

    public static void main(String[] args) {
        int interval[][] = { { 1, 3 }, { 6, 9 } };
        int res[][] = P08InsertInterval.insert(interval, new int[] { 2, 5 });
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }

    public  static int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        ArrayList<int[]> res = new ArrayList<>();
        int i=0;
        //push all before intervals to array
        while(i<n && intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        //case of merge
        while(i<n && newInterval[0]<=intervals[i][1] && newInterval[1]>=intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        int[][] arr = new int[res.size()][2];
        for(int j=0;j<arr.length;j++){
            arr[j][0] = res.get(j)[0];
            arr[j][1] = res.get(j)[1];
        }

        return arr;
    }

    
}

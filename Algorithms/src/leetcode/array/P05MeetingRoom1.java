package leetcode.array;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * 
 * Input: [[7,10],[2,4]]
 * Output: true
 */
public class P05MeetingRoom1 {
    public static void main(String[] args) {
        // int input[][] = new int[][]{{7,10},{2,4}} ;
        int input[][] = new int[][]{{0,30},{5,10},{15,20}} ;
        boolean res = P05MeetingRoom1.meetingRoom(input);
        System.out.println(res);
    }

    public static boolean meetingRoom(int[][]rooms){
        Arrays.sort(rooms,(a,b)-> a[0]-b[0]);
        for(int i=1;i<rooms.length;i++){
            if(rooms[i][0]<rooms[i-1][1]){
                return false;
            }
        }
        return true;
    }

}

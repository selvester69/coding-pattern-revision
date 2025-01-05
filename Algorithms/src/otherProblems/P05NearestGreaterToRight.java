package otherProblems;

import java.util.Arrays;
import java.util.Stack;

public class P05NearestGreaterToRight {
	

	public static void main(String[] args) {
		int[] res = P05NearestGreaterToRight.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
		System.out.println(Arrays.toString(res));
//		res = P05NearestGreaterToRight.nearestGreater(new int[] { 30, 40, 50, 60 });
//		System.out.println(Arrays.toString(res));
//		res = P05NearestGreaterToRight.nearestGreater(new int[] { 30, 60, 90 });
//		System.out.println(Arrays.toString(res));
	}
	
	public static int[] dailyTemperatures(int[] temperatures) {
	       Stack<Integer> s = new Stack<>();
	       int[] answer = new int[temperatures.length];

	       for (int i=0; i<temperatures.length; i++) {
	           int curr = temperatures[i];
	           while (!s.isEmpty() && curr > temperatures[s.peek()]) {
	               int prevGreater = s.pop();
	               answer[prevGreater] = (i-prevGreater);
	           }
	           s.push(i);
	       }
	       return answer;
	    }

	public static int[] nearestGreater(int[] nums) {
		int[] ans = new int[nums.length];
		Stack<Integer> st = new Stack<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				ans[i] = 0;
			} else if(!st.isEmpty() && st.peek()>nums[i]) {
				ans[i] = st.peek();
			}else if(st.size()>0 && st.peek()<=nums[i]) {
				while (!st.isEmpty() && st.peek() <= nums[i]) {
					st.pop();
				}
				if(st.isEmpty()) {
					ans[i]=0;
				}else {
					ans[i]=st.peek();
				}
			}
			st.push(nums[i]);
		}
		System.out.println(st);
		System.out.println(Arrays.toString(nums));
		
		return ans;
	}
}

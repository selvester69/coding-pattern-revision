package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class P06DailyTemperatures {
	static class Pair {
		int el;
		int index;

		public Pair(int el, int index) {
			this.el = el;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		int[] res = P06DailyTemperatures.dailyTemperaturesApproach3(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
		System.out.println(Arrays.toString(res));
		res = P06DailyTemperatures.dailyTemperaturesApproach3(new int[] { 30, 40, 50, 60 });
		System.out.println(Arrays.toString(res));
		res = P06DailyTemperatures.dailyTemperaturesApproach3(new int[] { 30, 60, 90 });
		System.out.println(Arrays.toString(res));
	}
	
	//another approach optimized
	public static int[] dailyTemperaturesApproach3(int[] temperatures) {
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
	

	// further optimize -> store index in stack instead of values.
	public static int[] dailyTemperaturesApproach2(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		Stack<Integer> st = new Stack<>();
		for (int i = temperatures.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				ans[i] = 0;
			} else if (!st.isEmpty() && temperatures[st.peek()] > temperatures[i]) {
				ans[i] = st.peek() - i;
			} else if (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
				while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					ans[i] = 0;
				} else {
					ans[i] = st.peek() - i;
				}
			}
			st.push(i);
		}
		return ans;
	}

//	optmize using stack<int,int> to O(N)
	public static int[] dailyTemperaturesApproach1(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		Stack<Pair> st = new Stack<>();
		for (int i = temperatures.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				ans[i] = 0;
			} else if (!st.isEmpty() && st.peek().el > temperatures[i]) {
				ans[i] = st.peek().index - i;
			} else if (!st.isEmpty() && st.peek().el <= temperatures[i]) {
				while (!st.isEmpty() && st.peek().el <= temperatures[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					ans[i] = 0;
				} else {
					ans[i] = st.peek().index - i;
				}
			}
			st.push(new Pair(temperatures[i], i));
		}
		return ans;
	}

	// simple O(N^2) solution
	public static int[] dailyTemperaturesBruteForce(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		for (int i = 0; i < temperatures.length - 1; i++) {
			int ngr = 0;
			for (int j = i + 1; j < temperatures.length; j++) {
				if (temperatures[j] > temperatures[i]) {
					ngr = j - i;
					break;
				}
			}
			ans[i] = ngr;
		}
		return ans;
	}
}

package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class P08AsteroidCollision {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(P08AsteroidCollision.asteroidCollision(new int[] {5,10,-5})));
		System.out.println(Arrays.toString(P08AsteroidCollision.asteroidCollision(new int[] {8,-8})));
		System.out.println(Arrays.toString(P08AsteroidCollision.asteroidCollision(new int[] {10,2,-5})));
		System.out.println(Arrays.toString(P08AsteroidCollision.asteroidCollision(new int[] {-2,-1,1,2})));
	}
	
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<asteroids.length;i++) {
			if(asteroids[i]>0) {
				st.push(asteroids[i]);
			}else {
				while(!st.isEmpty()&& st.peek()>0 && st.peek()<Math.abs(asteroids[i])) {
					st.pop();
				}
				if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])) {
					st.pop();
				}else if(st.isEmpty()|| st.peek()<0) {
					st.push(asteroids[i]);
				}
			}
		}
		int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;		
		
	}

}

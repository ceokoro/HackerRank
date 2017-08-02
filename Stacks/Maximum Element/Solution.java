import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
		int numQueries = in.nextInt();
		int max = Integer.MIN_VALUE;
		Stack<StackNode> stack = new Stack<StackNode>();
		for (int i = 0; i < numQueries; i++) {
			int query = in.nextInt();


			if (query == 1) {
				int input = in.nextInt();
				max = Math.max(max, input);

				stack.push(new StackNode(input, max));
			} else if (query == 2) {
				if (!stack.isEmpty()) {
					stack.pop();
				}

				if (!stack.isEmpty()) {
					max = stack.peek().max;
				} else
					max = Integer.MIN_VALUE;
			} else if (query == 3) {
				if (!stack.isEmpty()) {
					System.out.println(stack.peek().max);
				}
			}
		}
		in.close();
	}

	static class StackNode {
		public int value;
		public int max;

		public StackNode(int value, int max) {
			this.value = value;
			this.max = max;
		}
	}
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
		Stack<Integer> first = new Stack<Integer>();
		Stack<Integer> second = new Stack<Integer>();
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int type = in.nextInt();
			if (type == 1) { // Enqueue
				int x = in.nextInt();
				first.push(x);
			} else if (type == 2) { // Dequeue
				moveToSecond(first, second);
				second.pop();
			} else { // Print Front
				moveToSecond(first, second);
				System.out.println(second.peek());
			}
		}
	}

	private static void moveToSecond(Stack<Integer> first, Stack<Integer> second) {
		if (second.isEmpty()) {
			while (!first.isEmpty()) {
				second.push(first.pop());
			}
		}
	}
}

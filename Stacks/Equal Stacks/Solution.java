import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		int h1[] = new int[n1];
		for (int h1_i = 0; h1_i < n1; h1_i++) {
			h1[h1_i] = in.nextInt();
		}
		int h2[] = new int[n2];
		for (int h2_i = 0; h2_i < n2; h2_i++) {
			h2[h2_i] = in.nextInt();
		}
		int h3[] = new int[n3];
		for (int h3_i = 0; h3_i < n3; h3_i++) {
			h3[h3_i] = in.nextInt();
		}

		Stack<Integer> first = new Stack<Integer>();
		int firstSize = 0;
		for (int i = h1.length - 1; i >= 0; i--) {
			first.push(h1[i]);
			firstSize += h1[i];
		}

		Stack<Integer> second = new Stack<Integer>();
		int secondSize = 0;
		for (int i = h2.length - 1; i >= 0; i--) {
			second.push(h2[i]);
			secondSize += h2[i];
		}

		Stack<Integer> third = new Stack<Integer>();
		int thirdSize = 0;
		for (int i = h3.length - 1; i >= 0; i--) {
			third.push(h3[i]);
			thirdSize += h3[i];
		}

		// System.out.println(first.peek());
		// System.out.println(second.peek());
		// System.out.println(third.peek());

		while (firstSize != secondSize || firstSize != thirdSize) {
			if (firstSize < secondSize) {
				if (!second.isEmpty()) {
					secondSize -= second.peek();
					second.pop();
				}
			} else if (firstSize < thirdSize) {
				if (!third.isEmpty()) {
					thirdSize -= third.peek();
					third.pop();
				}
			} else if (firstSize > secondSize || firstSize > thirdSize) {
				if (!first.isEmpty()) {
					firstSize -= first.peek();
					first.pop();
				}
			}
		}

		System.out.println(firstSize);

		in.close();
    }
}


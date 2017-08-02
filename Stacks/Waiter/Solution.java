import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] number = new int[n];
		for (int number_i = 0; number_i < n; number_i++) {
			number[number_i] = in.nextInt();
		}
		ArrayList<Stack<Integer>> bStacks = new ArrayList<Stack<Integer>>();
		ArrayList<Stack<Integer>> aStacks = new ArrayList<Stack<Integer>>();

		for (int j = 0; j < q + 1; j++) {
			aStacks.add(j, new Stack<Integer>());
			bStacks.add(j, new Stack<Integer>());
		}

		for (int j = 0; j < number.length; j++) {
			aStacks.get(0).push(number[j]);
		}

		for (int i = 1; i <= q; i++) {
			int p = getNumberedPrime(i);

			Stack<Integer> b = bStacks.get(i);
			Stack<Integer> a = aStacks.get(i);
			while (!aStacks.get(i - 1).isEmpty()) {
				int x = aStacks.get(i - 1).pop();
				if (x % p == 0)
					b.push(x);
				else
					a.push(x);
			}
		}

		for (int i = 0; i < bStacks.size(); i++) {
			if (!bStacks.get(i).isEmpty()) {
				print(bStacks.get(i));
			}
		}

		for (int i = 0; i < aStacks.size(); i++) {
			if (!aStacks.get(i).isEmpty()) {
				print(aStacks.get(i));
			}
		}

		in.close();
	}

	private static void print(Stack<Integer> stack) {
		while (!stack.empty())
			System.out.println(stack.pop());
	}

	private static int getNumberedPrime(int n) {

		int num = 1;

		while (n > 0) {
			int temp = getNextPrime(num + 1);
			num = temp;
			n--;
		}

		return num;
	}

	private static int getNextPrime(int tableSize) {
		if (tableSize == 2)
			return 2;

		if (tableSize % 2 == 0)
			tableSize++;
		boolean isPrime = isPrime(tableSize);

		while (!isPrime) {
			tableSize = tableSize + 2;
			isPrime = isPrime(tableSize);
		}
		return tableSize;
	}

	private static boolean isPrime(int tableSize) {
		int sqRoot = (int) Math.sqrt(tableSize);
		boolean prime = true;

		if (tableSize < 2) {
			prime = false;
		} else if (tableSize == 2 || tableSize == 3)
			prime = true;
		else {
			for (int i = 3; i <= sqRoot; i += 2) {
				if (tableSize % i == 0)
					prime = false;
			}
		}

		return prime;
	}

}

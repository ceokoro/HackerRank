import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            System.out.println( (isBalanced(s)) ? "YES" : "NO" );
        }
    }
    
    public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = expression.toCharArray();
		for (char character : arr) {
			if (character == '{' || character == '[' || character == '(')
				stack.push(character);
			else {
				if (stack.isEmpty())
					return false;

				char pop = stack.pop();
				if (pop != getClosingBracket(character))
					return false;
			}
		}

		if (!stack.isEmpty())
			return false;

		return true;
	}

	public static Character getClosingBracket(char word) {
		switch (word) {
		case '}':
			return '{';
		case ']':
			return '[';
		default:
			return '(';
		}
	}
}


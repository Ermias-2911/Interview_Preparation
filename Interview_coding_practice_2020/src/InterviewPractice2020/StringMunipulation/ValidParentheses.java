package InterviewPractice2020.StringMunipulation;

import java.util.Stack;
// Author Ermias Haile
// LeetCode Question
// August 17, 2020
// Valid Parentheses

// Input: "()[]{}"
//		Output: true

// Input: "([)]"
//		Output: false

// Input: "{[]}"
//		Output: true
public class ValidParentheses {
	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		if (s.length() % 2 == 1)
			return false;

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (ch == '{' || ch == '[' || ch == '(') {
				st.push(ch);
			} else if (!st.isEmpty()) {
					char match = st.pop();
					if (match == '{' && ch != '}')
						return false;
					else if (match == '[' && ch != ']')
						return false;
					else if (match == '(' && ch != ')')
						return false;
			}
		}
		if (!st.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String st1 = "{{[{]}}}";
		String st2 = "([{()}])";
		String st3 = "{{[{]}}}";
		System.out.println(" String Input " + st2 + " is: ===> " + isValid(st2));
	}
}


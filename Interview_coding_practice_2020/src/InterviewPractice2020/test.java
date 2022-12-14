package InterviewPractice2020;

import java.util.Arrays;
import java.util.Stack;

// Find the contigous subarray with an array which has the largest product.
public class test {
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char element : chars) {
            if (element == '(' || element == '[' || element == '{') {
                stack.push(element);
                continue;
            } else if (stack.empty()) {
                return false;
            }
            char top = stack.pop();
            if (top == '(' && element != ')') {
                return false;
            } else if (top == '[' && element != ']') {
                return false;
            } else if (top == '{' && element != '}') {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String st1 = "{{[{]}}}";
        char[] a = {'[','{',')',']','(',')'};
        Arrays.sort(a);
        System.out.println(" a: " + Arrays.toString(a));
        String st2 = "([{()}])";
        String st3 = "{{[{]}}}";
        System.out.println(" String Input " + st2 + " is: ===> " + isValid(st2));
    }
}
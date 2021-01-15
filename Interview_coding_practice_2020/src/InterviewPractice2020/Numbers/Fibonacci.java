package InterviewPractice2020.Numbers;

import java.sql.SQLOutput;

public class Fibonacci {

	public static int nthFibonacciTerm(int n) {
		if (n == 1 || n == 0) {
			return n;
		}
		return nthFibonacciTerm(n-1) + nthFibonacciTerm(n-2);
	}
	public static void main(String[] args) {
	int num = 7;
	int re = nthFibonacciTerm(num);
		System.out.println("Result: " + re);
	}
}

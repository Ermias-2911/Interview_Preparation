package InterviewPractice2020.Numbers;


import java.util.HashMap;
import java.util.Map;

// Dynamic Programing ( a method for solving a complex problem by breaking it down into a collection of simpler subproblems,
// solving each of those subproblems just once, and storing their solutions using a memory-based data structure (array, map, etc.).
public class Fibonacci {

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);

	}

	// Another way Fibonacci
	// Function to find n'th Fibonacci number
	public static int fib(int n)
	{
		if (n <= 1) {
			return n;
		}

		int x = 0, y = 1;
		for (int i = 0; i < n - 1; i++)
		{
			int z = x + y;
			x = y;
			y = z;
			System.out.println("Fib " + 8 + " is ==> " + y);
		}
		return y;
	}


	public static void main(String[] args) {
		int num = 8;
		System.out.println("Fibonacci with recursion of " + num + " is: ==> "+ fibonacci(num));
		System.out.println(" ");
		System.out.println("Fibonacci with Iteration of " + num + " is: ==> " + fib(num));

	}
}

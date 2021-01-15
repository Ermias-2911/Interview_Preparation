package InterviewPractice2020;

// Author Ermias Haile
// August 26, 2020
// Rotational Cipher

public class GcdAndLcm {

	public static void findGCD(int x, int y) {
		int gcd = 1;

		for (int i = 1; i <= x && i <= y; ++i) {
			// Checks if i is factor of both integers
			if (x % i == 0 && y % i == 0)
				gcd = i;
		}

		System.out.printf("G.C.D of %d and %d is %d", x, y, gcd);
	}


	public static void findLCM(int x, int y) {
		int gcd = 1;

		for (int i = 1; i <= x && i <= y; ++i) {
			// Checks if i is factor of both integers
			if (x % i == 0 && y % i == 0)
				gcd = i;
		}

		int lcm = (x * y) / gcd;
		System.out.printf("\nL.C.M of %d and %d is %d", x, y, lcm);
	}


	public static void main(String[] args) {
		int x = 0X000F;
		System.out.println("xx: " + x);
		findGCD(4, 8);
		findLCM(4, 8);
	}
}

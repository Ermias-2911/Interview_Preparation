package InterviewPractice2020.AllOtherCodingProblems;
import java.util.*;

public class EqualAndHashCodeImplementation {



		public static int findDistnictNumber(List<Sides> s) {
			int count = 0;
			for (int i = 0; i < s.size(); i++) {
				for (int j = i + 1; j < s.size(); j++) {

					if (s.get(i).equals(s.get(j))) {
						System.out.println("Counter number: ");
						count++;

					}
				}
			}
			if (s.get(0).hashCode() != (s.get(1).hashCode())) {

			}
			return s.size() - count + (count > 1 ? 1 : 0);
		}

		public static void main(String[] args) {

			List<Sides> list = new ArrayList<>();
			list.add(new Sides(2, 4));
			list.add(new Sides(2, 4, 5));
			list.add(new Sides(1, 1, 0));
			list.add(new Sides(2, 4, 5));
			list.add(new Sides(7, 7, 7));

			System.out.println(" Result: " + findDistnictNumber(list));
		}

		public static class Sides {
			private int a;
			private int b;
			private int c;

			Sides(int a, int b, int c) {
				this.a = a;
				this.b = b;
				this.c = c;
			}

			Sides(int a, int b) {
				this.a = a;
				this.b = b;
			}

			public int getA() {
				return a;
			}

			public int getB() {
				return b;
			}

			public int getC() {
				return c;
			}

			@Override
			public boolean equals(Object obj) {

				if (this == obj) {
					return false;
				}

				if (obj == null || this.getClass() != obj.getClass()) {
					return false;
				}

				Sides s = (Sides) obj;
				if (s.getA() != this.a || s.getB() != this.b || s.getC() != this.c) {
					return false;
				}

				return true;
			}

			@Override
			public int hashCode() {
				return Objects.hash(a, b, c);
			}
		}


	}

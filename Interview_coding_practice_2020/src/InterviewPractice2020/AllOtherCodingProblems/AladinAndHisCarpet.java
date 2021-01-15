package InterviewPractice2020.AllOtherCodingProblems;

import java.util.ArrayList;
import java.util.List;

public class AladinAndHisCarpet {

// Author Ermias Haile
// September 10, 2020

// Aladdin and his Carpte problem
// Determine the lowest index of the starting points form which Aladdin can start his
// his journey and visit all of the places in the circular path inorder. If ther is no solution return -1.
// magic = [2,4,5,2]  dist = [4,3,1,3]

// Solution
// magic[1] = 4
// 4 - dist[1] + magic[2] = 4 -  3 + 5 = 6
// 4 - dist[2] + magic[3] = 6 - 1 + 2 = 7
// 4 - dist[3] + magic[0] = 7 - 3 + 2 = 6
// 6 - dist[0] = 6 - 4 = 2

	// The first point form where Aladdin can start his jounry is the second magical source. So, output is 1.

	public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
		int position = -1, current = 0, total = 0;
		for (int i = 0; i < magic.size(); i++) {
			int diff = magic.get(i) - dist.get(i);
			current += diff;
			total += diff;
			if (current < 0) {
				current = 0;
				position = i;
			}
		}
		return total >= 0 ? position + 1 : -1;
	}

	public static void main(String[] args) {
		List<Integer> magic = new ArrayList<>();
		List<Integer> dist = new ArrayList<>();
		magic.add(2);
		magic.add(4);
		magic.add(5);
		magic.add(2);

		dist.add(4);
		dist.add(3);
		dist.add(1);
		dist.add(3);

		int result = optimalPoint(magic, dist);
		System.out.println(" Result: " + result);
	}
}


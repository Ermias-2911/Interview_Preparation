package InterviewPractice2020.Numbers.SubArrayProblems;
import java.util.Arrays;

public class SubSetCheck {

	static boolean isSubset(int set[], int subSet[], int m, int n) {
		int i = 0, j = 0;

		if (m < n)
			return false;

		Arrays.sort(set); //sorts set
		Arrays.sort(subSet); // sorts subSet
        System.out.println("set" + Arrays.toString(set));
		System.out.println("subSet" + Arrays.toString(subSet));
		while (i < n && j < m) {
			if (set[j] < subSet[i])
				j++;
			else if (set[j] == subSet[i]) {
				j++;
				i++;
			} else if (set[j] > subSet[i])
				return false;
		}

		if (i < n)
			return false;
		else
			return true;
	}


	public static void main(String[] args) {
		int set[] = {10, 15, 17, 19, 20, 22};
		int subSet[] = {22, 8, 7, 1};

		int m = set.length;
		int n = subSet.length;

		if (isSubset(set, subSet, m, n))
			System.out.println("subSet is a subset of set");
		else
			System.out.println("subSet is not a subset of set");
	}
}
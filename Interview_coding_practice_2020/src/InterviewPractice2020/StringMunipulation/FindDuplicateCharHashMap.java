package InterviewPractice2020.StringMunipulation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindDuplicateCharHashMap {

	public static void duplicate(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		while (i < s.length()) {

			char ch = s.charAt(i);

			// To skip withe space
			if (ch > 32) {

				if (map.containsKey(ch)) {
					map.put(ch, map.get(ch) + 1);
				} else {
					map.put(ch, 1);
				}
			}
			i++;
		}

		for (Map.Entry<Character, Integer> en : map.entrySet()) {
			if (en.getValue() > 1) {
				System.out.println(en.getKey() + " duplicated " + en.getValue() + " times");
			}
		}

	}

	public static void main(String args[]) {

		String s = "Programming is great!";
		System.out.println();

		duplicate(s);
	}
}


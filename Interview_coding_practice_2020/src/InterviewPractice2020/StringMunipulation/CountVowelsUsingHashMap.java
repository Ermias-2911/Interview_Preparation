package InterviewPractice2020.StringMunipulation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountVowelsUsingHashMap {

	public static void countVowles(String str) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char s = str.charAt(i);
			char x = s;
			boolean bl = false;
			if (s > 32) {
				switch (s) {
					case 'a':
						bl = true;
						break;
					case 'o':
						bl = true;
						break;
					case 'u':
						bl = true;
						break;
					case 'b':
					case 'i':
						bl = true;
						break;
					case 'e':
						bl = true;
						break;
					default:
						bl = false;
				}
			}
			if (bl) {
				if (map.containsKey(s)) {
					map.put(s, map.get(s) + 1);
				} else {
					map.put(s, 1);
				}
			}
		}
		for (
				Map.Entry<Character, Integer> p : map.entrySet()) {
			if (p.getValue() >= 1) {
				System.out.println("Output: " + p.getKey() + "  repeates " + p.getValue());
			}
		}
	}




	// Without switch statement
	public static void containVowelsWithOutWitchStatement(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {

			str.toLowerCase();
			char x = str.charAt(i);

			if (x == 'a' || x == 'i' || x == 'o' || x == 'u' || x == 'e') {

				if (map.containsKey(x)) {
					map.put(x, map.get(x) + 1);
				} else {
					// String s = Character.toString(x);
					map.put(x, 1);
				}
			}
		}

		for (Object key : map.keySet()) {

				System.out.println("The vowel " + key + " comes " + map.get(key) + " times!");
			}

	}

	// driver program to test above function
	public static void main(String[] args) {
		String srt = "Jeremiah Haile";
		countVowles(srt);
		System.out.println(" Or ");
		containVowelsWithOutWitchStatement(srt);
	}
}
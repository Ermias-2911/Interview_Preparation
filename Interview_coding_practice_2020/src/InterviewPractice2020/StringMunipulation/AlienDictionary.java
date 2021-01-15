package InterviewPractice2020.StringMunipulation;

import java.util.LinkedHashMap;
import java.util.Map;

public class AlienDictionary {
// Author Ermias Haile
// Augest 18, 2020
// Aliedn Dictionary
// In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
// Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

// Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
// Output: true

//	Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//	Output: false

//	Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//	Output: false

	public static boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}

		for (int j = 0; j < words.length - 1; j++) {

			int min = Math.min(words[j].length()-1, words[j+1].length()-1);
			for (int k = 0; k <= min; k++) {

				if (map.get(words[j].charAt(k)) < map.get(words[j + 1].charAt(k))) {
					break;
				} else if (map.get(words[j].charAt(k)) > map.get(words[j + 1].charAt(k))) {
					return false;
				}

				if( k == min) {
					if (words[j].length()-1 > min )
						return false;
					else
						break;
				}
			}
		}
		return true;
	}


	public static void main(String[] args) {
		String order = "worldabcefghijkmnpqstuvxyz";
		String[] words = {"word","world","row"};
		System.out.println(" Result: " + isAlienSorted(words, order));
	}
}


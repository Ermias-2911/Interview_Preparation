package InterviewPractice2020.StringMunipulation;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

// Author Ermias Haile
// LeetCode Question
// August 20, 2020

// Input: "abcabcbb"
//		Output: 3

// Input: "bbbbb"
//		Output: 1

// Input: "pwwkew"
//		Output: 3

// Sliding Window Technique
//  Longest Substring Without Repeating Characters (characters connected with out repeating character)


public class LongestSubstringWithoutRepeatingCharacters {

		public static int lengthOfLongestSubstring(String str) {
			Set<Character> set = new HashSet<>();
			int leftIndex = 0;
			int rightIndex = 0;
			int max = 0;

			while (rightIndex < str.length()) {

				if(!set.contains(str.charAt(rightIndex))){
					set.add(str.charAt(rightIndex));
					max = Math.max(max, set.size());
					rightIndex++;
				}else{
					set.remove(str.charAt(leftIndex));
					leftIndex++;
				}
			}
			return max;
		}
		public static void main(String[] args) {

			String s = "abcabcbb";
			System.out.println(" Result: " + lengthOfLongestSubstring(s));
		}
	}

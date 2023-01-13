package InterviewPractice2020.StringMunipulation;
import java.util.*;

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
			Set<Character> set = new LinkedHashSet<>();
			int second_slide = 0;
			int first_slide = 0;
			int max = 0;

			while (first_slide <= str.length()-1) {

				if(set.add(str.charAt(first_slide))){

					System.out.println("Added char: ==> " + str.charAt(first_slide));
					max = Math.max(max, set.size());
					first_slide++;
				}else{
					System.out.println(" ");
					 set.remove(str.charAt(second_slide));
					System.out.println("Removed char: ==> " + str.charAt(second_slide));
					System.out.println(" ");
					second_slide++;
				}
			}
			return max;
		}
		public static void main(String[] args) {

			String s = "abcabcbb";
			// Expected 3
			String ss = "pwwkew";
			// Expected 2
			String sss = "au";
			System.out.println(" The longest substring without repeating character is: ===> " + lengthOfLongestSubstring(ss));
		}
	}

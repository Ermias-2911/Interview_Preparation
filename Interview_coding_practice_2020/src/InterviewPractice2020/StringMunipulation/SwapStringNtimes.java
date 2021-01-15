package InterviewPractice2020.StringMunipulation;

import java.util.Arrays;

public class SwapStringNtimes {

	public static void maxNum(String st, String m) {

		String[] str = new String[st.length()];
		int count = 0;
		boolean check = true;
		for (int i = 0; i < st.length()-1; i++) {
			if ( check && count < Integer.parseInt(m)) {
				str[i+1] = String.valueOf(st.charAt(i));
				str[i] = String.valueOf(st.charAt(i+1));
				check = false;
				count++;
			} else if ( check && count >= Integer.parseInt(m)) {
				str[i] = String.valueOf(st.charAt(i));
				str[i+1] = String.valueOf(st.charAt(i+1));
				count++;
			} else{
				check = true;
			}
			if( st.length() % 2 != 0 && i == st.length() -2){
				str[i+1] = String.valueOf(st.charAt(i+1));
			}
		}
		System.out.println("R: " + Arrays.toString(str));
	}


	public static void main(String args[]) throws Exception {
		String st = "1345899";
		String m = "3";
		maxNum(st, m);
	}
}

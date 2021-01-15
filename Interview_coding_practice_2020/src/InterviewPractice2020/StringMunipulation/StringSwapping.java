package InterviewPractice2020.StringMunipulation;
public class StringSwapping {
	// Swap String n times
	public static String swapStringNtimes(String st, String n) {
		int count = 1;
		StringBuilder bu = new StringBuilder();

		for (int i = 0; i < st.length() - 1; i = i + 2) {
			if (count <= Integer.parseInt(n)) {

				bu.append(st.charAt(i + 1));
				bu.append(st.charAt(i));
				count++;
			} else {
				bu.append(st.charAt(i));
				bu.append(st.charAt(i + 1));
			}
			if (st.length() % 2 != 0 && i == st.length() - 3) {
				bu.append(st.charAt(i + 2));
			}
		}
		return bu.toString();
	}


	public static String rotateString(String stt ){
		StringBuilder buRotate = new StringBuilder(stt);

		if(stt.length() % 2 == 0) {

			int m = stt.length() / 2;
			return buRotate.substring(m,stt.length()) + buRotate.substring(0,m);
		}
		return "";
	}

	public static void main(String args[]){
		String st = "214365";
		String stt = "214365";
		String n = "3";
		int b = -121;
		int c = -3233233;
		int r = b + c;

		System.out.println("Unswapped String: " + st);
		System.out.println("Swapped String " + n + " times are: " + swapStringNtimes(st, n));
		Object [] str={'i','n','c','l','u','d','e','h','e','l','p'};
		String sr = str.toString();
		System.out.println("Object test: " + sr);
		System.out.println("Rotate String:  " + rotateString(stt));
	}
}

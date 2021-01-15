package InterviewPractice2020.StringMunipulation;

// Author Ermias Haile
// August 26, 2020
// Rotational Cipher

public class RotationalCipher {

	public static String rotationalCipher(String input, int rotationFactors) {

		StringBuilder st = new StringBuilder();
		// Check rotationFactor value to make it between 1 - 26
		int rotationFactor = rotationFactors % 9;

		for (int i = 0; i < input.length(); i++) {

			char ch = input.charAt(i);

			// Alphabets handled here
			if (Character.isAlphabetic(ch)) {

				int difference = ch - 'a';

				// Uppercase handled here
				if (Character.isUpperCase(ch)) {
					char chh = Character.toLowerCase(ch);
					int val = (('z' - 'a') - (chh - 'a'));

					// To check overflow and roationFactor alphabet
					if (val < rotationFactor) {
						int overFlow = rotationFactor - val;
						char addOverFlow = (char) ((overFlow - 1) + 'a');
						st.append(Character.toUpperCase(addOverFlow));
					} else {
						char ad = (char) ((difference + rotationFactor) + 'a');
						st.append(Character.toUpperCase(ad));
					}
				} else { // Lowercase handled here

					int val = (('z' - 'a') - (ch - 'a'));

					// To check overflow and roationFactor alphabet
					if (val < rotationFactor) {
						int overFlow = rotationFactor - val;
						char addOverFlow = (char) ((overFlow - 1) + 'a');
						st.append(addOverFlow);
					} else {

						char ad = (char) ((difference + rotationFactor) + 'a');
						st.append(ad);

					}
				}

			} else if (Character.isDigit(ch)) {  // Numbers handled here

				// Another way to convert form char to int primitive
				// int x = Character.getNumericValue(ch);
				int n = Integer.parseInt(String.valueOf(ch));

				int diffN = 9 - n;

				// To check overflow and roationFactor Number
				if (diffN < rotationFactor) {
					int offsetN = rotationFactor - diffN;
					st.append(offsetN);
				} else {
					n += rotationFactor;
					st.append(n);
				}
			} else {
				st.append(ch);
			}

		}
		return st.toString();
	}

	public static void main(String[] args) {

		// 	Expected output_1 = expected_1 = "Epp-gsrzsCw-3-fi:Epivx5."
		String input_1 = "All-convoYs-9-be:Alert1.";
		int rotationFactor_1 = 4;

		// 	Expected output_2 = "stuvRPQrpq-999.@";
		String input_2 = "abcdZXYzxy-999.@";
		int rotationFactor_2 = 200;

		String result = rotationalCipher(input_1, rotationFactor_1);
		System.out.println(" Output of median : " + result);
	}
}

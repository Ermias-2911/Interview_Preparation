package InterviewPractice2020.StringMunipulation;

public class PermutationSecondSolution {

    static void printPermutn(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);


            // Rest of the string after excluding the ith character
            String ros = str.substring(0, i) + str.substring(i + 1);

            // Recurvise call "abc"

            // printPermutn(bc, a)
            // printPermutn(c, ab)
            // printPermutn( , abc)

            // printPermutn(b, ac)
            // printPermutn(, acb)
            // printPermutn(ac, b)

            // printPermutn(c, ba)
            // printPermutn(, bac)
            // printPermutn(a, bc)

            // printPermutn(, bca)
            // printPermutn(ab, c)
            // printPermutn(b, ca)

            // printPermutn(, cab)
            // printPermutn(a, cb)
            // printPermutn(, cba)
            printPermutn(ros, ans + ch);

        }
    }

    // Driver code
    public static void main(String[] args) {
        String s = "abb";
        System.out.println("Permutation of " + s + " is: ");
        printPermutn(s, "");

    }
}

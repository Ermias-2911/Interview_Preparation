package InterviewPractice2020.StringMunipulation;

public class StringReverseRecursively {

    /* Function to print reverse of the passed string */
    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "Programming is fun";
        System.out.println("Reversed String: " + reverse(str));
    }
}

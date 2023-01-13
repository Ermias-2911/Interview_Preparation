package InterviewPractice2020.StringMunipulation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemovingCharacter {

    public static String removingCharacters(String str){

        String stt = str.replace("#", "").replace( "?", "").replace("/", "")
                .replace("}", "").replace("*", "");

        return stt;
    }

    public static String[] removingCharacters_2(String str){

        String[] ss = str.split("[|?/]");

        return ss;
    }

    public static void main(String[] args) {

        // 	Expected output_1 = expected_1 = "Epp-gsrzsCw-3-fi:Epivx5."
        String input_1 = "Progra#min?g/, i}s, *fu/n";
        String input_2 = "1.777|jefkk-77|jjksc?CCHJ-8889/KKEJ-789";

        String st = removingCharacters(input_1);
        String[] str = removingCharacters_2(input_2);

        System.out.println(" String Array with removed Characters :======>  " + Arrays.toString(str));
        System.out.println(" String with removed Characters :======>  " + st);
    }
}

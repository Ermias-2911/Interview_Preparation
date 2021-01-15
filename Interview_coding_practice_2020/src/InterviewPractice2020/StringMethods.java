package InterviewPractice2020;
import java.util.Arrays;
// Author Ermias Haile
// August 20, 2020

public class StringMethods {

		public static void main(String[] args) {
			// st and stt are always equal because both refer to the same instance
			String s = "jesus Is Life";
			String st = "jesusIsLife";
			String stt = new String("Jesus Is Life");
			System.out.println("\n         ########################################  STRING  ###################################   ");
			System.out.println("s : [ " +s.toString() + " ]" + "   " + "st : [ " +st.toString() + " ]"  + "   " + "stt : [ " +stt.toString() + " ]");


			System.out.println("st.charAt(0) :  -------> " + st.charAt(0));
			System.out.println("st.equals(stt) : -------> " +  st.equals(stt));
			System.out.println("st.compareTo(stt) == 0 : ------->  " + (st.compareTo(stt) == 0));
			System.out.println("st.indexOf('e')) : ------->  " + st.indexOf('e'));
			System.out.println("st.lastIndexOf('e') : ------->  " + st.lastIndexOf('e'));
			System.out.println("stt.substring(0, 5) : ------->  " + stt.substring(0, 5) );
			System.out.println("stt.replace(\" \", \"-\") : ------->  " + stt.replace(" ", "-"));
			System.out.println("stt.concat(\"!\") : ------->  " + st.concat("!"));
			System.out.println("stt.trim() (it removes lef and right space) : ------->  " + stt.trim() );
			String[] starr = s.split("");
			System.out.println("String[] starr = s.split(\"\") : ------->  " + Arrays.toString(starr));

		}
	}
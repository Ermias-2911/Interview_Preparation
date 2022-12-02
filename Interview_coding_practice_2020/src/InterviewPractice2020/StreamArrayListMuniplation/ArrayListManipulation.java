package InterviewPractice2020.StreamArrayListMuniplation;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListManipulation {

	public static List<String>  findTheSecondName(List<String> st){
		List<String> stt = new ArrayList<>();
		for (int i = 0; i < st.size(); i++) {
		  String ch = st.get(i);
			if(!stt.contains(ch)){
				stt.add(st.get(i));
			}
		}


		return stt;
	}


	public static void main(String args[]) throws Exception {
		List<Integer> integerList = Arrays.asList(10, 11, 20, 21, 30, 31, 40, 41);
		System.out.println(" integerList :======> " + integerList);

		List<String> stringList = Arrays.asList("Ermias", "Ermias", "Caleb", "Isaya", "Tomas", "Caleb", "Rahel", "Tomas");
		System.out.println(" stringList :======> " + stringList);

		List<String> intNumberString = Arrays.asList("10", "11", "20", "21", "30", "31", "40", "41");
		System.out.println(" intNumberString :======> " + intNumberString);

		System.out.println("");
		System.out.println("      ############################ Array to List  ########################### ");
		// ##################################################  Array to List  #############################################

		// Using Arrays.asList(array) only for non Primitive type
		Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
		int[] sourceArrayPrimitive = { 0, 1, 2, 3, 4, 5 };
		List<Integer> targetList = new ArrayList<>(Arrays.asList(sourceArray));

		// Using Arrays.asList(array) only for non Primitive type
		List<Integer> targetLis = Arrays.asList(sourceArray);

		// Using java 8 Stream primitive array to to List
		List<Integer> g = Arrays.stream(sourceArrayPrimitive)
								.boxed()
								.collect(Collectors.toList());

		// Using Arrays.asList() primitive array to List
		List<Integer>  k = Arrays.asList(4,5,6);



		// Converting List into Array
		Integer[]   inL = targetList.toArray(new Integer[targetList.size()]);
		System.out.println("inL: " + Arrays.toString(inL));

	    // or
		Integer[] inl = new Integer[targetList.size()];
		targetList.toArray(inl);

		// List subList
		List<String> s = stringList.subList(0,  3);
		System.out.println(" List subList : " + s.toString());

		// Collections sort
		Collections.sort(stringList);
		System.out.println(" Collections sort : " + stringList.toString());

		// Collections Binary Search
		int target = Collections.binarySearch(stringList, "Tomas");
		System.out.println(" Collections Binary Search for Tomas is in index : " + target);

		targetList.add(4);
		System.out.println(" s: " + targetList.toString());
		List<String> result =   findTheSecondName(stringList);
		System.out.println(" Filtered Array List: " + result.toString());


		System.out.println("");
		System.out.println("     ############################ Stream Api List to List Conversion  ########################### ");
		// ##################################################  List to List Conversion #############################################


		// Convert List String to List Integer or Double or Long and Vis versa:
		List<Integer> intR = intNumberString.stream().map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(" ====>>>  List String to List Integer ==> Using map(Integer::valueOf) :>>>>>  " + intR);
		// Vv
		List<String> strR = integerList.stream().map(String::valueOf).collect(Collectors.toList()); // or
		List<String> r = integerList.stream().map(Object::toString).collect(Collectors.toList());
		System.out.println(" ====>>>  List Integer to List String ==> Using map(String::valueOf) :>>>>>  " + strR);


		// Convert List String to List Char Vis versa:
		List<Character> chR = stringList.stream().flatMapToInt(x -> x.chars()).mapToObj(i -> (char) i).collect(Collectors.toList());
		System.out.println(" ====>>>  List String to List Char ==> Using flatMapToInt(x -> x.chars()).mapToObj(i -> (char) i) :>>>>>  " + chR);
		// Vv
		String stR = chR.stream().map( u-> u.toString()).collect(Collectors.joining());
		System.out.println(" ====>>>  List Char to List String ==> Using map( u-> u.toString()) :>>>>>  " + stR);

		// Convert List to Array Vis versa:
		int[] intArray = integerList.stream().mapToInt(i->i).toArray();
		System.out.println(" ====>>>  List Integer to Array int ==> Using mapToInt(i->i).toArray() :>>>>>  " + Arrays.toString(intArray));

		String[] strArray = stringList.stream().toArray(n -> new String[stringList.size()]);
		System.out.println(" ====>>>  List String to Array String ==> Using toArray(n -> new String[stringList.size()]) :>>>>>  " + Arrays.toString(strArray));
		// Vv
		List<String>  arrayToList = Arrays.asList(strArray);
		System.out.println(" ====>>>  Array to List ==> Using Arrays.asList(strArray) :>>>>>  " + arrayToList);

		List<Integer> IntList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		System.out.println(" ====>>>  Array to List ==> Using Arrays.stream(intArray).boxed().collect(Collectors.toList()) :>>>>>  " + IntList);

	}

}

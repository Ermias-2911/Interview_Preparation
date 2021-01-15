package InterviewPractice2020.ArrayListMuniplation;

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
		List<String> st = new ArrayList<>();
		st.add("Ermias");
		st.add("Abigael");
		st.add("Caleb");
		st.add("Isaya");
		st.add("Tomas");
		st.add("Caleb");
		st.add("Rahel");
		st.add("Tomas");

////////////////////////////////////////////  Array to List /////////////////////////////////////////

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
		List<String> s = st.subList(0,  3);
		System.out.println("\nList subList : " + s.toString());

		// Collections sort
		Collections.sort(st);
		System.out.println("\nCollections sort : " + st.toString());

		// Collections Binary Search
		int target = Collections.binarySearch(st, "Tomas");
		System.out.println("\nCollections Binary Search for Tomas is in index : " + target);

		targetList.add(4);
		System.out.println("\ns: " + targetList.toString());
		List<String> result =   findTheSecondName(st);
		System.out.println("\nFiltered Array List: " + result.toString());

	}
}

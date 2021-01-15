package InterviewPractice2020.MapMuniplation;

import java.util.*;

public class MapMuniplation {

	public static void main(String[] args) {
		//Creating HashMap with default initial capacity and load factor
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		LinkedHashMap<String, Integer> map2 = new LinkedHashMap<>();

		//Inserting key-value pairs to map using put() method
		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THREE", 3);
		map.put("FOUR", 4);
		map.put("FIVE", 5);
		Set<List<Integer>>   l = new HashSet<>();
Arrays.asList(334,4);
		// Iterating map with Map.Entry
		for(Map.Entry< String, Integer> it : map.entrySet()){
			System.out.println(it.getKey() + " ==> " + it.getValue());
		}

		System.out.println(" ");

		//Checking whether key '3' exist in map
		System.out.println(map.containsKey("ONE"));  //Output : true
		System.out.println(map.containsValue(2));   //Output : true

		//Clearing the map
		// map.clear();

		System.out.println(" ");

		// Iterating only key
		for (String key : map.keySet()) {
			System.out.println("Key ==>: " + key);
		}

		System.out.println(" ");

		// Iterating only value
		//Collection<Integer> values = map.values();
		for (Integer val : map.values()) {
			System.out.println("Value ==>: " + val);
		}

		// Remove the mapping
		// map.remove("ONE");

		// Remove the mapping if the key and value corresponds
		// map.remove("ONE", 1);

		// Replace value
		// map.replace("TWO", 22);

		// Replace value if key and value corresponds
		//map.replace("TWO", 2, 222);

		// To create synchronized map
		// Map<String, Integer> syncMap = Collections.synchronizedMap(map);

		System.out.println(" ");

		// To find max value
		int maxValue = Collections.max(map.values());
		System.out.println("Max value is: " + maxValue);


		// To find key max value
		String maxKey = Collections.max(map.keySet());
		System.out.println("Max key value is: " + maxKey);


		// Sort values only
		List<Integer>  sortV = new ArrayList<>(map.values());
		Collections.sort(sortV);
		System.out.println("Sorted value with ArrayList : " + sortV.toString());

		System.out.println(" ");
//
//		// Sorting map by value ascending order only with LinkedHashmap work
//		map.entrySet().stream()
//				.sorted(Map.Entry.comparingByValue())
//				.forEachOrdered(x -> map2.put(x.getKey(), x.getValue()));
//		System.out.println("Sorted Map by value ascending order: " + map2);

		System.out.println(" ");

		// Sorting map by value descending order only with LinkedHashmap work
		map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> map2.put(x.getKey(), x.getValue()));
		System.out.println("Sorted Map by vlaue decending order : " + map2);

		System.out.println(" or without stream ");


		// Sorting map by value ascending order by List and Collections.sort()
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
				return a.getValue().compareTo(b.getValue());
			}
		});
		System.out.println("Sorted Map by value ascending order: " + entries);
	}
}
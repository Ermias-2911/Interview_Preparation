package InterviewPractice2020.MapMuniplation;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapMuniplationWithObject {

	public static Map<String, Students> partitionArray(Map<String, Students> map) {
		Map<String, Students> sortedMap = new LinkedHashMap<>();

		// Sort map by value
		map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.comparing(Students::getName).thenComparing(Students::getAge)))
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		// Sort map by value another way
		Map<String, Students> sortedMap2 = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.comparing(Students::getAge).thenComparing(Students::getName)))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap2;
	}


	public static void main(String args[]) throws Exception {
		Map<String, Students> map = new LinkedHashMap<>();

		Students st1 = new Students("Ermi", 30, "2F");
		Students st2 = new Students("Abigael", 25, "4f");
		Students st3 = new Students("Yonas", 35, "3F");

		map.put(st1.getName(), st1);
		map.put(st2.getName(), st2);
		map.put(st3.getName(), st3);

		Map<String, Students> re = partitionArray(map);

		System.out.println("<==================  Sorted Output =================> ");
		re.entrySet().stream()
				.forEach(x -> System.out.println(x.getKey() + " : " + x.getValue().getName() + " , " + x.getValue().getAge() + " , " + x.getValue().getHeight()));

	}

}

class Students {
	private int age;
	private String name;
    private String height;
	Students(String name, int age, String height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public String getName() {
		return name;
	}
	public int getAge() { return age; }
	public String getHeight() {
		return height;
	}
}


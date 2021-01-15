package InterviewPractice2020.Numbers;

import java.util.*;
import java.util.stream.Collectors;

public class PartitionArrayAndSaveSumOfValueOnMap {

	public static Map<indexObject, Integer> partitionArray(int[] arr) {
		Map<indexObject, Integer> mp = new LinkedHashMap<>();

		for (int i = 0; i <= arr.length - 1; i += 2) {
			indexObject ind = new indexObject(i, i == arr.length - 1 ? -1 : i + 1);
			mp.put(ind, arr[i] + (i == arr.length - 1 ? 0 : arr[i + 1]));
		}

		Map<indexObject, Integer> sort = mp.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(x, y) -> x, LinkedHashMap::new));

		return sort;
	}


	public static void main(String args[]) throws Exception {
		int[] arr = {4, 6, 2, 7, 19, 12, 3};

		Map<indexObject, Integer> re = partitionArray(arr);

		System.out.println("<==================  Sorted Output =================> ");
		re.entrySet().stream()
				.forEach(x -> System.out.println(x.getKey().getfIndex() + " , " + x.getKey().getsIndex() + " : " + x.getValue()));
	}

}

class indexObject {
	private int fIndex;
	private int sIndex;

	indexObject(int fIndex, int sIndex) {
		this.fIndex = fIndex;
		this.sIndex = sIndex;
	}

	public int getfIndex() {
		return fIndex;
	}

	public int getsIndex() {
		return sIndex;
	}
}


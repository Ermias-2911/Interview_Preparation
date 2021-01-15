package InterviewPractice2020.LooselyCupling;

public class SearchingAlogorithm {

	public static void main (String[] args){
		MainSearch   mainSearch = new MainSearch(new ButtomSearch());
		int[] arr = {2,4,6,8,10,12};
		String result = mainSearch.search(arr, 8);
		System.out.println(">>>>>> " + result);
	}

}

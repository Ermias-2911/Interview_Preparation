package InterviewPractice2020.LooselyCupling;

public class MainSearch {

	private LoosellyInterface loosellyInterface;

	// To assign different object instance
	public MainSearch(LoosellyInterface loosellyInterface) {
		this.loosellyInterface = loosellyInterface;
	}

	public String search(int[] arr, int t) {

		// call multiple method
		String res = loosellyInterface.topAndButomSearch(arr, t);
		System.out.println(">>>>>> " + res);
		return "Return from Main Search	";
	}
}

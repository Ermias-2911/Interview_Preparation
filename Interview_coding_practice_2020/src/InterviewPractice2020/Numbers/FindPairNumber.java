package InterviewPractice2020.Numbers;

public class FindPairNumber {

    public static void findPair(int arr[], int result) {

        for (int i = 0; i < arr.length; i++) {

            int find = result - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (find == arr[j]) {
                    System.out.println("pare foudn at index: " + j + " resut = " + arr[i] + " + " + arr[j]);
                }
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 4, 6, 10, 5, 2};
        int result = 6;
        findPair(arr, result);
    }

}


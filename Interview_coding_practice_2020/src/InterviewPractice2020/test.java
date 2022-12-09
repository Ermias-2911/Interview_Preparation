package InterviewPractice2020;
class test {
    /// Function to print duplicates
    static int findMaxSumWithNoAdjucent(int arr[]) {
        int maxOne = arr[0];
        int maxTwo = 0;

        int avoidOverFlow = (arr.length)/2 == 0  ? (arr.length -1 ) : (arr.length -2);

        for (int i = 0; i <= avoidOverFlow; i+=2) {

            if( i != avoidOverFlow){
                maxOne += arr[i+2];
            }
            if (i == avoidOverFlow && ( arr.length % 2 != 0 )){
               break;
            }else{
                maxTwo += arr[i +1];
            }
        }
        return Math.max(maxTwo, maxOne);
    }
        // Driver program
        public static void main (String[]args){
            int arr[] = {1, 2, 9, 4, 5, 0, 4, 11, 6};
            int result = findMaxSumWithNoAdjucent(arr);
            System.out.println(" Result of max sume is: " + result);

        }
}
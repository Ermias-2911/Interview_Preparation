package InterviewPractice2020.Numbers;

public class FindingDuplicateUsingHashing {
    public static int findDuplicate(int[] nums)
    {
        // create a visited array of size `n+1`
        // we can also use a map instead of a visited array
        boolean visited[] = new boolean[nums.length + 1];


        for (int value: nums)
        {
            // if the element is seen before
            if (visited[value]) {
                return value;
            }

            // mark element as visited
            visited[value] = true;
        }

        // no duplicate found
        return -1;
    }

    public static void main (String[] args)
    {

        int[] nums = { 1, 2, 3, 4, 4 };

        System.out.println("The duplicate element is " + findDuplicate(nums));
    }
}
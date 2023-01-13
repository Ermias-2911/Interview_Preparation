package InterviewPractice2020;
import java.util.*;

// Finding the max events in a single room
public class test {


    static int maxEvents(int[] start, int[] end) {
        int arrLen =   start.length;
        int[][] arr2D = new int[arrLen][2];

        for(int i=0; i<arrLen; i++) {
            arr2D[i] = new int[] {start[i], end[i]};
        }

        PriorityQueue<Integer> priorQ = new PriorityQueue<>();
        Arrays.sort(arr2D, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0, maxEvent = 0, d = 0;
        while (!priorQ.isEmpty() || i < arrLen) {
            // Get the first start date
            if (priorQ.isEmpty())
                d = arr2D[i][0];
            // Update priorQ based on end date
            while (i < arrLen && arr2D[i][0] <= d) {
                //Add ending date
                priorQ.offer(arr2D[i++][1]);
            }
            //once you attended the event soon , then remove it from the priorQ
            priorQ.poll();
            ++maxEvent; ++d;

            // if events overlaps or days already occupied then simply discard it
            while (!priorQ.isEmpty() && priorQ.peek() < d)
                priorQ.poll();
        }
        return maxEvent;
    }




        public static void main(String[] args) {

            int[] start = {1,3,0,5,8,5 };
            int[] end = {2,4,6,7,9,9 };

            int[] start1 = {1,1,2};
            int[] end2 = {3,2,4};

            int[] start3 = {1,4,0,6,9,10 };
            int[] end4 = {3,5,7,8,11,12};

            int maxResult = maxEvents(start3, end4);
            System.out.println("The max meetings that can be scheduled is :====>  " + maxResult);
    }
}


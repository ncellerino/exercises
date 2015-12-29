package codility.lesson4.counting;

/**
 * 100%
 * @author Jorge
 *
 */
public class MaxCounters {
    
    public static void main(String[] args){
        int N = 5;
      //  int[] A = {3,4,4,6,1,4,4};
        int[] A = {1,6,2,6,3,6,4,6,5,6};
        System.out.println(new MaxCounters().solution(N, A));
    }
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        if (N <= 0 || N > 100000) {
            throw new IllegalArgumentException();
        }

        int[] array = new int[N];
        int maxValueToSet = 0;
        int maxCounter = 0;
        for (int i = 0; i < A.length; i++) {
            int operation = A[i];
            if (operation <= N) {
                // increment counter
                int counter = array[operation-1];
                if (counter < maxValueToSet) {
                    array[operation-1] = maxValueToSet+1;                    
                } else {
                    array[operation-1] = ++counter;                    
                }
                if (array[operation-1] > maxCounter) {
                    maxCounter = array[operation-1];
                }
            } else if (operation == N + 1) {
                maxValueToSet = maxCounter;
            }else{
                throw new IllegalArgumentException();
            }
        }

        // set the missing counters
        for (int i = 0; i < array.length; i++) {
            if (array[i] < maxValueToSet) {
                array[i] = maxValueToSet;
            }
        }
        return array;
    }

}

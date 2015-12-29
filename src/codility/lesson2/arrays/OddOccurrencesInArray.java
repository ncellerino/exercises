package codility.lesson2.arrays;

import java.util.Arrays;

/**
 * 100%
 * @author Jorge
 *
 */
public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 11, 9 };
        System.out.println(new OddOccurrencesInArray().solution(A));
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return -1;
        }
        Arrays.sort(A);
        int occurrences = 0;
        int lastNumber = 0;
        for (int i = 0; i < A.length; i++) {
            if (occurrences == 0) {
                lastNumber = A[i];
                occurrences++;
            } else {
                if (A[i] == lastNumber) {
                    occurrences++;
                } else {
                    if (occurrences % 2 != 0) {
                        return lastNumber;
                    }
                    lastNumber = A[i];
                    occurrences = 1;
                }
            }
        }
        if(occurrences % 2 != 0){
            return lastNumber;
        }
        
        return 0;
    }
}

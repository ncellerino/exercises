package codility.lesson7.maximumSliceProblem;
/**
 * 53%
 * @author jorge.cellerino
 *
 */
public class MaxDoubleSliceProblem {

    public static void main(String[] args) {
        int[] A = { 3, 2, 6, -1, 4, 5, -1, 2 };
        System.out.println(new MaxDoubleSliceProblem().solution(A));
    }

    public int solution(int[] A) {

        int[] sumLeft = new int[A.length - 1];
        int[] sumRight = new int[A.length - 1];
        for (int i = 1; i < sumLeft.length; i++) {
            sumLeft[i] = Math.max(0, A[i] + sumLeft[i - 1]);
        }
        for (int i = sumRight.length - 2; i > 0; i--) {
            sumRight[i] = Math.max(0, A[i] + sumRight[i + 1]);
        }

        int maxSlice = 0;
        for (int i = 2; i < sumLeft.length - 1; i++) {
            maxSlice = Math.max(maxSlice, sumLeft[i - 1] + sumRight[i + 1]);
        }

        return maxSlice;
    }
    
    
    
}

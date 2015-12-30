package codility.lesson9.maximumSliceProblem;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class MaxSliceSum {
    
    public static void main(String[] args){
       int[] A = {3,2,-6,4,0};
       // int[] A = {-4,-2,-6,-1};
        System.out.println(new MaxSliceSum().solution(A));
    }

    public int solution(int[] A) {
        int maxEnding = A[0];
        int goldenMax = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEnding = Math.max(A[i], A[i] + maxEnding);
            goldenMax = Math.max(goldenMax, maxEnding);
        }
        return goldenMax;
    }
}

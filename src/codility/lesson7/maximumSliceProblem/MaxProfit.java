package codility.lesson7.maximumSliceProblem;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };
        System.out.println(new MaxProfit().solution(A));
    }

    public int solution(int[] A) {
        if(A.length == 0){
            return 0;
        }
        int[] diff = new int[A.length - 1];

        for (int i = 0; i < A.length - 1; i++) {
            diff[i] = A[i + 1] - A[i];
        }

        int maxProfit = 0;
        int maxEnding = 0;
        for (int i = 0; i < diff.length; i++) {
            maxEnding = Math.max(0, diff[i] + maxEnding);
            maxProfit = Math.max(maxEnding, maxProfit);
        }
        return maxProfit;
    }

}

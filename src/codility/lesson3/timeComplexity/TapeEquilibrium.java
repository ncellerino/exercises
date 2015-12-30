package codility.lesson3.timeComplexity;

import java.util.Arrays;

public class TapeEquilibrium {

    public static void main(String[] args) {
//        int[] A = {3, 1, 2, 4, 3 };
        int[] A = {-1000, 1000};
        System.out.println(new TapeEquilibrium().solution(A));
    }

    public int solution(int[] A) {

        int sum = Arrays.stream(A).sum();

        int leftSum = 0;
        int rightSum = sum;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < A.length-1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            minDiff = Math.min(Math.abs(leftSum - rightSum), minDiff);
        }
        return minDiff;
    }

}

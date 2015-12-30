package codility.lesson5.prefixSums;

/**
 * 80% using carterpillar method
 * @author Jorge
 *
 */
public class MinAvgTwoSlice {

    public static void main(String[] args) {
        int[] A = {4, 2, 2, 5, 1, 5, 8 };
        System.out.println(new MinAvgTwoSlice().solution(A));
    }

    public int solution(int[] A) {
        int[] prefixSums = getPrefixSums(A);

        int minIndex = 0;
        int rightIndex = 0;
        int n = A.length;
        double minAvg = Double.MAX_VALUE;
        for (int leftIndex = 0; leftIndex < n - 1; leftIndex++) {
            rightIndex = leftIndex + 1;
            double parcialMinAvg = avgSlice(prefixSums, leftIndex, rightIndex);
            while (rightIndex < n) {
                double avg = avgSlice(prefixSums, leftIndex, rightIndex);
                if (avg > parcialMinAvg) {
                    break;
                } else {
                    parcialMinAvg = avg;
                }
                rightIndex++;
            }
            if (parcialMinAvg < minAvg) {
                minAvg = parcialMinAvg;
                minIndex = leftIndex;
            }
        }
        return minIndex;
    }

    private static int[] getPrefixSums(int[] A) {
        int[] prefixSums = new int[A.length + 1];
        for (int i = 1; i < prefixSums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + A[i - 1];
        }
        return prefixSums;
    }

    private static double avgSlice(int[] prefixSums, int A, int B) {
        return (double) sumSlice(prefixSums, A, B) / (B - A + 1);
    }

    private static int sumSlice(int[] prefixSums, int A, int B) {
        return prefixSums[B + 1] - prefixSums[A];
    }
}

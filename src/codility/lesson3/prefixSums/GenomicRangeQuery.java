package codility.lesson3.prefixSums;

public class GenomicRangeQuery {

    private static int A = 0;
    private static int C = 1;
    private static int G = 2;
    private static int T = 3;

    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0 };
        int[] Q = {4, 5, 6 };
        System.out.println(new GenomicRangeQuery().solution(S, P, Q));
    }

    public int[] solution(String S, int[] P, int[] Q) {
        
        int[][] genomicArray = new int[4][S.length() + 1];

        for (int i = 1; i < S.length() + 1; i++) {
            char character = S.charAt(i - 1);
            int a = 0;
            int c = 0;
            int g = 0;
            int t = 0;
            if (character == 'A') {
                a = 1;
            } else if (character == 'C') {
                c = 1;
            } else if (character == 'G') {
                g = 1;
            } else {
                t = 1;
            }

            genomicArray[A][i] = genomicArray[A][i - 1] + a;
            genomicArray[C][i] = genomicArray[C][i - 1] + c;
            genomicArray[G][i] = genomicArray[G][i - 1] + g;
            genomicArray[T][i] = genomicArray[T][i - 1] + t;
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int from = P[i];
            int to = Q[i] + 1;
            if (genomicArray[A][to] - genomicArray[A][from] > 0) {
                result[i] = 1;
            } else if (genomicArray[C][to] - genomicArray[C][from] > 0) {
                result[i] = 2;
            } else if (genomicArray[G][to] - genomicArray[G][from] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }
        return result;
    }

}

package codility.lesson11.eratosthenes;

public class CountNonDivisible {

    public static void main(String[] args) {
       // int[] A = {3, 1, 2, 3, 6, 9, 13, 15, 16, 18 };
        int[] A = {3, 1, 2, 3, 6};
        // int[] A = {2 };
        System.out.println(new CountNonDivisible().solution(A));
    }
    
    private static int OCCURRENCES = 0;
    private static int DIVISORS = 1;

    public int[] solution(int[] A) {
        int N = A.length;
        int[][] count = new int[N * 2 + 1][2];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            // count occurrences
            count[A[i]][OCCURRENCES]++;
            // count divisors
            count[A[i]][DIVISORS] = -1;
        }

        // counting divisors
        for (int i = 0; i < N; i++) {
            int number = A[i];
            if (count[number][1] == -1) {
                int divisors = 0;
                for (int j = 1; j <= Math.sqrt(number); j++) {
                    if (number % j == 0 && number/j != j) {
                        divisors += count[j][OCCURRENCES];
                        divisors += count[number/j][OCCURRENCES];
                    } else if(number % j == 0 && number/j == j){
                        divisors += count[j][OCCURRENCES];
                    }
                }
                count[number][DIVISORS] = divisors;
            }
        }
        for (int i = 0; i < N; i++) {
            result[i] = N - count[A[i]][DIVISORS];
        }

        return result;
    }
}

package beatmycode;

import java.util.Arrays;

public class WordRank {

    public static void main(String[] args) {
        String input = "BMC_TEST_INPUT_MAGIC";
       
        if (input.length() == 0) {
            System.out.println(0);
        } else {
            char[] letters = input.toCharArray();
            int N = letters.length;
            char[] sortedLetters = Arrays.copyOf(letters, letters.length);

            int fact = getFactorial(N);

            int[] characters = new int[N];

            Arrays.sort(sortedLetters);
            int position = 0;
            int blockSize = fact / N;
            for (int i = 1; i < N; i++) {
                char c = letters[i - 1];
                for (int j = 0; j < N; j++) {
                    if (c != sortedLetters[j]) {
                        if (characters[j] == 0)
                            position += blockSize;
                    } else {
                        // mark the character
                        characters[j] = 1;
                        break;
                    }
                }

                blockSize = blockSize / (N - i);
            }

            position++;

            System.out.println(position);
        }
    }

    private static int getFactorial(int N) {
        int factorial = N;
        for (int i = N - 1; i > 0; i--) {
            factorial = factorial * (i);
        }
        return factorial;
    }

}

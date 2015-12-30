package codility.lesson10.primeAndCompositeNumbers;

import java.util.LinkedList;
import java.util.List;

public class Flags {

    public static void main(String[] args) {
        int[] A = {1,5,3,4,3,4,1,2,3,4,6,2};
        System.out.println(new Flags().solution(A));
    }

    public int solution(int[] A) {
        int N = A.length;

        List<Integer> peeks = new LinkedList<Integer>();
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peeks.add(i);
            }
        }

        int flagsToSet = peeks.size();
        while (flagsToSet > 0) {
            int flagsSet = 0;
            int previousFlag = 0;
            int peeksLeft = peeks.size();
            int flagsLeftToSet = flagsToSet;
            for (Integer peek : peeks) {
                if (flagsSet == 0) {
                    flagsSet++;
                    flagsLeftToSet--;
                    previousFlag = peek;
                } else {
                    if (Math.abs(previousFlag - peek) >= flagsToSet) {
                        flagsSet++;
                        flagsLeftToSet--;
                        previousFlag = peek;
                    }
                }
                peeksLeft--;
                if (peeksLeft < flagsLeftToSet) {
                    break;
                }
            }
            if (flagsToSet == flagsSet) {
                return flagsSet;
            }
            flagsToSet--;
        }
        return 0;
    }
}

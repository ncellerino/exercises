package codility.lesson10.primeAndCompositeNumbers;

import java.util.LinkedList;
import java.util.List;

public class Peaks {

    public static void main(String[] args) {
        // int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        int[] A = {1, 2, 3, 4, 5, 6 };
        System.out.println(new Peaks().solution(A));
    }

    public int solution(int[] A) {
        int N = A.length;
        if (N < 3) {
            return 0;
        }

        List<Integer> peaks = new LinkedList<Integer>();
        // finding peeks
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        if (peaks.size() == 1)
            return 1;

        if (peaks.size() == 0)
            return 0;

        int blocks = 0;

        for (int blockSize = 2; blockSize < N; blockSize++) {
            boolean allGroupsWithPeak = true;
            // check if it can be divided in blocks of equal size
            if (N % blockSize != 0)
                continue;
            blocks = N / blockSize;
            allGroupsWithPeak = true;
            int groupLimitIdx = blockSize - 1;
            for (Integer peakIndex : peaks) {
                if (peakIndex > groupLimitIdx) {
                    allGroupsWithPeak = false;
                    break;
                }
                groupLimitIdx = groupLimitIdx + blockSize;
            }
            if (allGroupsWithPeak) {
                return blocks;
            }
        }

        return 0;
    }

}

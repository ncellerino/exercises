package codility.lesson2.counting;

import java.util.HashSet;
import java.util.Set;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class FrogRiverOne {

    public static void main(String[] args) {
        int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };
        int X = 5;
        System.out.println(new FrogRiverOne().solution(X, A));
    }

    public int solution(int X, int[] A) {
        if (A.length < X || A.length == 0 || X <=0) {
            return -1;
        }
        Set<Integer> leaves = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            leaves.add(A[i]);
            if (leaves.size() == X) {
                return i;
            }
        }
        return -1;
    }
}

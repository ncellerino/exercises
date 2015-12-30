package codility.lesson8.leader;

/**
 * 50%
 * @author jorge.cellerino
 *
 */
public class EquiLeader {

    public static void main(String[] args) {
        //int[] A = { 4, 3,4,4,4,2 };
        //int[] A = { 4, 2,4,2,4,2 };
        int[] A = {-1000000000,-1000000000 };
        System.out.println(new EquiLeader().solution(A));
    }

    public int solution(int[] A) {

        if (A.length < 2) {
            return 0;
        }

        int equileaders = 0;
        Integer leftLeader = 0;
        Integer rightLeader = 0;
        for (int i = 0; i < A.length; i++) {
            leftLeader = getGoldenLeader(A, 0, i);
            rightLeader = getGoldenLeader(A, i + 1, A.length - 1);
            if ((leftLeader != null && rightLeader != null) && leftLeader.equals(rightLeader)) {
                equileaders++;
            }

        }
        return equileaders;
    }

    private Integer getGoldenLeader(int[] A, int from, int to) {
        Integer leader = null;
        int size = 0;
        int candidate = 0;    

        if (from == to) {
            return A[from];
        }

        for (int i = from; i <= to; i++) {
            if (size == 0) {
                size++;
                candidate = A[i];
            } else if (candidate == A[i]) {
                size++;
            } else {
                size--;
            }
        }

        int count = 0;
        for (int i = from; i <= to; i++) {
            if (A[i] == candidate) {
                count++;
            }
        }
        if (count > (to - from + 1) / 2) {
            leader = candidate;
        }
        return leader;
    }

}

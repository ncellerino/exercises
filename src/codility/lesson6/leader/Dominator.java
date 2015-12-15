package codility.lesson6.leader;

public class Dominator {
    
    public static void main(String[] args){
        int[] A = {3};
        System.out.println(new Dominator().solution(A));
    }

    public int solution(int[] A) {
        int indexCandidate = -1;
        if (A.length == 0 || A.length == 2) {
            return indexCandidate;
        }               

        int candidate = 0;
        int size = 0;
        
        // find a golden candidate
        for (int i = 0; i < A.length; i++) {
            if (size == 0) {
                candidate = A[i];
                indexCandidate = i;
                size++;
            } else {
                if (A[i] == candidate) {
                    size++;
                } else {
                    size--;
                }
            }
        }

        // count the candidate occurrences
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
            }
        }
        if (count > A.length / 2) {
            return indexCandidate;
        } else {
            return -1;
        }

    }
}

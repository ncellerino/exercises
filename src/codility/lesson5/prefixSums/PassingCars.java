package codility.lesson5.prefixSums;

/**
 * 100%
 * @author Jorge
 *
 */
public class PassingCars {

    private static final int EAST = 0;
    private static final int WEST = 1;
    
    public static void main(String[] args){
        //int[] A = {0,1,0,1,1};
        //int[] A = {1,0};
        int[] A = {0,1};
        System.out.println(new PassingCars().solution(A));
    }

    public int solution(int[] A) {
        int goingEast = 0;
        int passingCars = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == EAST) {
                goingEast++;
            } else if(A[i] == WEST){
                passingCars = passingCars + goingEast;
                if(passingCars > 1000000000){
                    return -1;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        return passingCars;
    }

}

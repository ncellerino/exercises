package codility.lesson8.leader;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class EquiLeader2 {

    public static void main(String[] args) {
        //int[] A = { 4, 3,4,4,4,2 };
        int[] A = { 4, 2,4,2,4,2 };
        //int[] A = {-1000000000,-1000000000 };
        System.out.println(new EquiLeader2().solution(A));
    }

    public int solution(int[] A) {

        if (A.length < 2) {
            return 0;
        }               
        
        Integer leader = null;
        int size = 0;
        int candidate = 0;           
        //get a candidate
        for (int i = 0; i < A.length; i++) {
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
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
            }
        }
        if (count > (A.length / 2)) {
            leader = candidate;
        }
        int leadersLeft = 0;
        int leadersRight = count;
        int sizeLeft = 0;
        int sizeRight = A.length;
        int equileaders = 0;
        if(leader != null){
            for(int i = 0; i < A.length;i++){
                sizeLeft++;
                sizeRight--;
                if(A[i] == leader){
                    leadersLeft++;
                    leadersRight--;
                }
                if(isleader(sizeLeft, leadersLeft) && isleader(sizeRight, leadersRight)){
                    equileaders++;
                }
            }
        }else{
            return 0;
        }
         
        return equileaders;
    }

    private boolean isleader(int size, int occurrences){
        return occurrences > size/2;
    }
   
}

package codility.lesson2.counting;

import java.util.Arrays;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class PermCheck {
    
    public static void main(String[] args){
        //int[] A = {1,4,3,5};
        //int[] A = {1};
        int[] A = {1,4,3,5,2};
        //int[] A = {1,1,4,3,5,2};
        System.out.println(new PermCheck().solution(A));
    }

    public int solution(int[] A) {
        if(A.length == 0){
            throw new IllegalArgumentException();
        }
        Arrays.sort(A);
        if(A[0] != 1){
            return 0;
        }else{
            int previous = A[0];
            for(int i = 1; i < A.length;i++){
                if(A[i] - previous != 1){
                    return 0;
                }
                previous = A[i];
            }
        }
        return 1;
    }
}

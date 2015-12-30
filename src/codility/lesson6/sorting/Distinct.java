package codility.lesson6.sorting;

import java.util.Arrays;

/**
 * 100%
 * @author Jorge
 *
 */
public class Distinct {
    
    public static void main(String[] args){
        int[] A = {2,1,1,2,3,1};
        System.out.println(new Distinct().solution(A));
    }
    
    public int solution(int[] A) {
        if(A.length == 0){
            return 0;
        }
        
        Arrays.sort(A);
        
        int previous = A[0]; 
        int counter = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] != previous){
                counter++;
                previous = A[i];
            }
        }
        return counter;
    }

}

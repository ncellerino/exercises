package codility.lesson4.sorting;

import java.util.Arrays;

/**
 * 100%
 * @author Jorge
 *
 */
public class MaxProductOfThree {
    
    public static void main(String[] args){
        //int[] A = {-3,1,2,-2,5,6};
        int[] A = {-1000,0,2,-2000,5,6};
        System.out.println(new MaxProductOfThree().solution(A));
    }
    
    public int solution(int[] A) {
       
        if(A.length == 3){
            return A[0] * A[1] * A[2];
        }
       
       Arrays.sort(A);
       int n = A.length;
       if(A[0] >= 0){
           //all positives
           return A[n-1] * A[n-2] * A[n-3];
       }else{
           return Math.max(A[0] * A[1] * A[n-1], A[n-1] * A[n-2] * A[n-3]);
       }
       
    }

}

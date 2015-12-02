package codility.lesson2.counting;

import java.util.Arrays;


/**
 * 100%
 * @author Nico
 *
 */
public class MissingInteger {
    public static void main(String[] args){
        //int[] A =  {1,2,3,4,7,5,7,9,6};
        int[] A =  {1, 3, 6, 4, 1, -2,2,5}; //1,1,2,3,4,6
       System.out.println(new MissingInteger().solution(A));
    }
    
    public int solution(int[] A) {
        if(A.length == 0) {
            throw new IllegalArgumentException();
        }
        int minMissingInteger = 1;
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if(A[i] == minMissingInteger){
                minMissingInteger++;
            }
            if(A[i] > minMissingInteger){
                return minMissingInteger;
            }
        }
        return minMissingInteger;
               
    }
    
    
}

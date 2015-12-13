package codility.lesson4.sorting;

import java.util.Arrays;

/**
 * 93%
 * @author Jorge
 *
 */
public class Triangle {
    
    public static void main(String[] args){
        int[] A = {10,2,5,1,8,20};
        
        System.out.println(new Triangle().solution(A));
    }
    
    public int solution(int[] A) {
        if(A.length < 3){
            return 0;
        }
        
        if(A.length == 3) {
            if(isTriangle(A[0], A[1], A[2])){
                return 1;
            }else{
                return 0;
            }
        }
        
        Arrays.sort(A);
        
        for(int i = 0; i < A.length-2; i++){
            if(isTriangle(A[i], A[i+1], A[i+2])){
                return 1;
            }
        }
        
        return 0;
    }

    private boolean isTriangle(int x, int y, int z) {
        return (x + y > z) && (x + z > y) && (y + z > x);
    }
}

package codility.lesson99;

public class InverseArray {
    
    public static void main(String[] args){
        int[] A = {-1,6,3,4,7,4};
        System.out.println(new InverseArray().solution(A));
    }
    
    public int solution(int[] A){
        int inverseCount = 0; 
        if(A.length > 0){
            int minSeen = A[A.length-1];
            for(int i = A.length-2; i >= 0; i --){        
                int j = i+1;            
                if(A[i] > minSeen){
                    while(j < A.length){
                        if(A[i] > A[j]){
                            inverseCount++;
                        }
                        j++;
                    }   
                } else{
                    minSeen = A[i];
                }
            }   
        }        
        return inverseCount;
    }

}

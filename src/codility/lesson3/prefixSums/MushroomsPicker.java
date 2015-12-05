package codility.lesson3.prefixSums;

public class MushroomsPicker {
    
    public static void main(String[] args){
        int[] A = {2,3,7,5,1,3,9};
        int k = 4;
        int m = 6;
        
        System.out.println(new MushroomsPicker().solution(A, k, m));
    }
    
    public int solution(int[] A, int k, int m){
        int[] prefixSums = prefixSums(A);
        int n = A.length;
        int result = 0;
        //search to the left
        for(int p = 0; p < Math.min(k, m) + 1; p++){
            int leftPos = k - p;
            int rightPos = Math.min(n - 1, Math.max(k, k + m - 2 * p));
            result = Math.max(result, countSegment(prefixSums, leftPos, rightPos));
        }
      //search to the right
        for(int p = 0; p < Math.min(m + 1, n - k); p++){
            int rightPos = k + p;
            int leftPos = Math.max(0, Math.min(k,  k - (m - 2 * p)));
            result = Math.max(result, countSegment(prefixSums, leftPos, rightPos));
        }
        return result;
    }
    
    private int countSegment(int prefixs[], int A, int B){
        return prefixs[B+1] - prefixs[A];
    }
    
    private int[] prefixSums(int[] A){
        int[] sum = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            sum[i] = A[i - 1] + sum[i - 1];
        }
        return sum;
    }

}

package codility.lesson5.prefixSums;

/**
 * 62%
 * @author Jorge
 *
 */
public class CountDiv {
    public static void main(String[] args){
        int A = 6;
        int B = 11;
        int K = 2;
        
        System.out.println(new CountDiv().solution(A, B, K));
    }
    public int solution(int A, int B, int K) {
        if(K <= 0 || A < 0 || B < 0 || A > B) {
            throw new IllegalArgumentException();
        }
        if(A == 0){
            return B/K;
        }
        
        int divisorsB = B/K;
        int divisorsA = A/K;
        int offset = 0;
        if(A%K == 0){
            offset++;
        }
        //divisors in segment
        return divisorsB - divisorsA + offset;
    }
}

package codility.lesson8.primeAndCompositeNumbers;

/**
 * 92%
 * @author jorge.cellerino
 *
 */
public class CountFactors {

    public static void main(String[] args){
        int N = Integer.MAX_VALUE;
        System.out.println(new CountFactors().solution(N));
    }
    
    public int solution(int N) {
        if (N == 1) {
            return 1;
        }

        // 1 and N are factors
        int factors = 2;
        int i = 2;
        while (i * i <= N) {           
            if (N % i == 0) {
                if(N / i == i){
                    factors++;
                }else{
                    factors = factors + 2;    
                }                
            }
            i++;
        }       
        
        return factors;
    }
}

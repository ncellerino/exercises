package beatmycode;

import java.math.BigInteger;

/**
 * 100%
 * @author Jorge
 *
 */
public class KingsTravel {
    
    public static void main(String[] args){
        String movements = "1";
        BigInteger n =  new BigInteger(movements);
        BigInteger result = n.add(n).add(BigInteger.ONE).pow(2);
        
        
        if("1".equals(movements)){
           System.out.println(result.subtract(BigInteger.ONE));
        }else{
            System.out.println(result);
        }
    }

}

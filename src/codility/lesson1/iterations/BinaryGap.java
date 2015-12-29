package codility.lesson1.iterations;

/**
 * 100%
 * @author Jorge
 *
 */
public class BinaryGap {
    
    public static void main(String[] args){
        int N = 15;
        System.out.println(new BinaryGap().solution(N));
    }

    public int solution(int N){
        String binary = Integer.toBinaryString(N);
        boolean lastGapValid = false;
        if(binary.charAt(binary.length() -1) == '1'){
            lastGapValid = true;
        }
        String[] binArray = binary.split("1");
        int maxGap = 0;
        int currentGap = 0;
        
        for(int i = 0; i < binArray.length; i++){
            if(i == binArray.length -1 && !lastGapValid){
                break;
            }
            currentGap = binArray[i].length();
            maxGap = Math.max(currentGap, maxGap);            
        }
        
        return maxGap;        
    }
}

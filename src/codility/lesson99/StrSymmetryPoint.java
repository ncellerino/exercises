package codility.lesson99;

/**
 * 85%
 * @author jorge.cellerino
 *
 */
public class StrSymmetryPoint {

    public static void main(String[] args){
        String S = "aaaaaaaaaa";
        System.out.println(new StrSymmetryPoint().solution(S));
    }
    
    public int solution(String S){
        
        if(S.length() == 1){
            return 0;
        }
        if(S.length() == 2){
            return -1;
        }
        
        int index = (S.length() / 2);
        
        int leftIdx = index-1;
        int rightIdx = index+1;
        
        while(rightIdx <= S.length() && leftIdx >= 0){
            if(S.charAt(leftIdx) != S.charAt(rightIdx)){
                return -1;
            }
            leftIdx--;
            rightIdx++;
        }
        return index;
    }
}

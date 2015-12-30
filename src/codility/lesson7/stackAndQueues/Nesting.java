package codility.lesson7.stackAndQueues;

import java.util.Stack;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class Nesting {
    
    public static final int NESTED = 1;
    public static final int NOT_NESTED = 0;
    
    public static void main(String[] args){
        String S = "(()(())())";
       // String S = ")()";
       // String S = "(()(())()))";
        System.out.println(new Nesting().solution(S));
    }

    public int solution(String S) {
        // write your code in Java SE 8
        if(S == null) {
            throw new IllegalArgumentException();
        }
        
        if(S.length() == 0){
            return NESTED;
        }
        
        char[] chars = S.toCharArray();
        Stack<Character> parentheses = new Stack<Character>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '('){
                parentheses.push(chars[i]);
            }else{
                if(chars[i] == ')'){
                    if(parentheses.size() > 0){
                        parentheses.pop();    
                    }else{
                        return NOT_NESTED;   
                    }                                        
                }else{
                    throw new IllegalArgumentException();
                }
            }
        }
        if(parentheses.size() == 0){
            return NESTED;
        }else{
            return NOT_NESTED;
        }        
    }
}

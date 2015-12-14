package codility.lesson5.stackAndQueues;

import java.util.Stack;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class Brackets {
    
    public static void main(String[] args){
       // String S = "{[()()]}";
        String S = "{[())]}";
        System.out.println(new Brackets().solution(S));
    }
    
    private static final int NESTED = 1;
    private static final int NOT_NESTED = 0;

    public int solution(String S){
        if(S.length() == 0){
            return NESTED;
        }
        
        if(S.length() == 1){
            return NOT_NESTED;
        }
        
        Stack<Character> chars = new Stack<Character>();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(isOpening(c)){
                chars.push(c);
            }else {
                if(isClosing(c)){
                    if((chars.size() == 0) || !isClosingFor(chars.peek(), c)){
                        return NOT_NESTED;
                    }else{
                        chars.pop();
                    }
                }
            }
        }
        if(chars.size() > 0){
            return NOT_NESTED;
        }else{
            return NESTED;   
        }       
    }
    
    private boolean isClosingFor(char opening, char closing){
        return (opening == '{' && closing == '}') || (opening == '(' && closing == ')') ||(opening == '[' && closing == ']');
    }
    
    private boolean isOpening(char c){
        return (c == '{') || (c == '(') || (c == '[');
    }
    
    private boolean isClosing(char c){
        return (c == '}') || (c == ')') || (c == ']');
    }
    
}

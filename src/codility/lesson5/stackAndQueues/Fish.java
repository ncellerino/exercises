package codility.lesson5.stackAndQueues;

import java.util.Stack;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class Fish {
    
    public static void main(String[] args){
        int[] A = {4,3,2,1,5};
        int[] B = {1,1,1,1,1};
        System.out.println(new Fish().solution(A, B));
    }
    
    private static final int UPSTREAM = 0;
    private static final int DOWNSTREAM = 1;
    
    public int solution(int[] A, int[] B){
        if(A.length != B.length || A.length == 0 || B.length == 0){
            throw new IllegalArgumentException();
        }
        
        int alives = 0;
        Stack<Integer> upstream = new Stack<Integer>();
        for(int i = 0; i < B.length; i++){
            if(B[i] == DOWNSTREAM){
                upstream.push(A[i]);
            }else if(B[i] == UPSTREAM){
                boolean eaten = false;
                while(upstream.size() > 0 && !eaten){
                    if(A[i] > upstream.peek()){
                        upstream.pop();
                    }else{
                        eaten = true;
                    }
                }
                if(!eaten){
                    alives++;
                }
            }else{
                throw new IllegalArgumentException();
            }
        }
        return alives + upstream.size();
    }

}

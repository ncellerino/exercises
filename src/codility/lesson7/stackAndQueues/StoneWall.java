package codility.lesson7.stackAndQueues;

import java.util.Stack;

/**
 * 100%
 * @author jorge.cellerino
 *
 */
public class StoneWall {
    
    public static void main(String[] args){
        //int[] A = {8,8,5,7,9,8,7,4,8};
        int[] A = {7,5,5,2};
        System.out.println(new StoneWall().solution(A));
    }
    
    public int solution(int[] A){
        if(A.length < 2){
            return 1;
        }
        
        Stack<Integer> heights = new Stack<Integer>();
        int blocks = 0;
        int maxHeight = 0;
        for(int i = 0; i < A.length; i++){
            int height = A[i];
            if(height > maxHeight){
                heights.push(height);
                maxHeight = height;
                blocks++;
            }else if(height < maxHeight){
                while(heights.size() > 0 && height < heights.peek()){
                    heights.pop();                                        
                }
                maxHeight = height;
                if(heights.size() == 0 || height != heights.peek()){                    
                    heights.push(height);  
                    blocks++;
                }                
            }
        }
        return blocks;
    }

}

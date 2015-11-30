package beatmycode;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args){
		String input = "2:1";
		String[] inputs = input.split(":");
		int size = Integer.parseInt(inputs[0]);
		String sequence = inputs[1];
		String[] array = sequence.split(",");
		Arrays.sort(array);
		int previous = 0;
		int missing = 0;
		for(int i = 0; i < array.length; i++){
			int current = Integer.parseInt(array[i]);
			if(current - previous > 1){
				missing = current -1;
				break;
			}else{
				previous = current;
			}
		}
		if(missing != 0){
			System.out.println(missing);	
		} else {
			System.out.println(size);
		}
		
	}
}

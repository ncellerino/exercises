package beatmycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeckCards {

	public static void main(String[] args){
		String input = "BMC_TEST_INPUT_MAGIC";
		String[] cardArray = input.split(",");
		if(cardArray.length < 52){
			System.out.println(0);
		}else{
			Map<String, Integer> cards = new HashMap<String, Integer>();
			for(int i = 0; i < cardArray.length; i++){
				String key = cardArray[i];
				Integer value = cards.get(key);
				if(value == null){
					cards.put(key, 1);	
				}else{
					cards.put(key, ++value);
				}			
			}		
			List<Integer> countedCards = new ArrayList<Integer>(cards.values()); 
			if(countedCards.size() == 52){
				Collections.sort(countedCards);
				System.out.println(countedCards.get(0));
			}else{
				System.out.println(0);
			}					
		}		
	}
}

package TextMining1;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Map;
public class countWord {
    // map the words to their count
   

	public static Map<String, Float> countWords(ArrayList<String> list){
	Map<String, Float> frequencyMap = list.stream()
         .collect(toMap(
                s -> s , // key is the word
                s -> (float)1, // value is 1
                Float::sum)); // merge function counts the identical word

		return frequencyMap;
		}
}
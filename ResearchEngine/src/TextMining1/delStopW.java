package TextMining1;

import java.util.ArrayList;

public class delStopW {
	public static ArrayList<String> deleteStopWords(ArrayList<String> Query, ArrayList<String> stopWords){
    	ArrayList<String> cleanQuery = new ArrayList<String>();
	   	for(String word : Query)
		{
			if(!stopWords.contains(word))
			{	
				cleanQuery.add(word);
			}
		} 
		return cleanQuery;
	}
	

}
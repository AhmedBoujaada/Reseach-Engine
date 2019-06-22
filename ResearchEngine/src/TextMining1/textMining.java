package TextMining1;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toMap;
public class textMining {
    public static void main(String[] args)throws Exception 
    {
        System.out.println("Starting ...\n");
    	HashMap<File, HashMap<String,Float>> mapOfMap = new HashMap<File, HashMap<String, Float>>();

        //read stop words file word by word--------------------------------------------------------------------------------------------------------
    	File stopFile =new File("C:\\Users\\bdsas\\Desktop\\Text Mining\\listStopWords.txt");
    	ArrayList<String> stopWords = new ArrayList<String>();
    	stopWords= readFileAsArraylist.readFile(stopFile);
    	float IDFQuery; 
        ArrayList<String> list = new ArrayList<String>();
    	String t;
        //read my file word by word(words= tokens)--------------------------------------------------------------------------------------------------
		File directory = new File("C:\\Users\\bdsas\\Desktop\\Text Mining\\Documents");
		String filenames[] = directory.list();
        for(int j=0;j<filenames.length;j++) {
    	File dir= new File(directory+"\\"+filenames[j]);
        for (File file : dir.listFiles()) {
        	list= readFileAsArraylist.readFile(file);   	
        //clean my list -----------------------------------------------------------------------------------------------------------------------------
        	list = cleaning.clean(list);
        	list= delStopW.deleteStopWords(list, stopWords);
        	//Stemming-------------------------------------------------------------------------------------------------------------------------------
        	for(int i=0; i<list.size(); i++) 
        	list.set(i, stemming.StemmingFunction(list.get(i)));
        
        // map the words to their count---------------------------------------------------------------------------------------------------------------
        	Map<String, Float> frequencyMap = countWord.countWords(list);
        // the map of the map:------------------------------------------------------------------------------------------------------------------------
        	mapOfMap.put(file, (HashMap<String, Float>) frequencyMap);
        		
        }
        }
        //write my code in a file----------------------------------------------------------------------------------------------------------------------
        /*try (PrintWriter out = new PrintWriter("C:\\Users\\bdsas\\Desktop\\Text Mining\\myMapOfMap.txt")) {
            out.println(mapOfMap);
        		}*/
        
        //calculate the TF for every file--------------------------------------------------------------------------------------------------------------
        mapOfMap=calculWij.calculTFFunction(mapOfMap);
        
       
        //Starting Research -------------------------------------------------------------------------------------------------------------------------        
        System.out.println("محرك البحث :");     

        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();   
        scanner.close();
        String [] k= words.split(" ");
        ArrayList<String> Query= new ArrayList<String>(Arrays.asList(k));
        //clean my list ------------------------------------------------------------------------------------------------------------------------------
 
        Query = cleaning.clean(Query);    	 
    	Query= delStopW.deleteStopWords(Query, stopWords);
    	//while(Query.remove(""));
    	//Stemming ----------------------------------------------------------------------------------------------------------------------------------- 	    	
    	for(int i=0; i<Query.size(); i++) 
    	Query.set(i, stemming.StemmingFunction(Query.get(i)));
    	
        // count Cosinus of QUERY----------------------------------------------------------------------------------------------------------------------
    	Map<String, Float> frequencyQuery= countWord.countWords(Query);
    	Set<Entry<String, Float>> set = frequencyQuery.entrySet();
		

		for(Entry<String, Float> terme : set) {
			t = terme.getKey();
    		IDFQuery= calculIDF.calculIdf(mapOfMap,t);
    		terme.setValue(terme.getValue()*IDFQuery);
    	}

		Map<File, Float> cos=new HashMap<File, Float>();
    	cos = cosinus.cos(mapOfMap, frequencyQuery);
    		
    	cos= cos.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(
    				toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e2, LinkedHashMap::new));
    	int j=0;
        for(File c : cos.keySet()) {    
        	if(cos.get(c)==0 || j==10)
        		break;
        	else
        		System.out.println(c+" ===> "+cos.get(c));
        	j++;
        }
        System.out.println("Done !");
        }
}

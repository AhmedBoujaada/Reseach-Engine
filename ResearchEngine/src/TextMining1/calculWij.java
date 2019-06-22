package TextMining1;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class calculWij {
	public static HashMap<File, HashMap<String,Float>> calculTFFunction(HashMap<File, HashMap<String,Float>> mapOfMap) {
        Set<Entry<File, HashMap<String, Float>>> set1 = mapOfMap.entrySet();
        Map<String, Float> map2 ;
        Set<Entry<String, Float>> set2;
        float sizeSet2;
        Float IDF, TF, wij;
        String terme;
        for (Entry<File, HashMap<String, Float>> e1 : set1) {
        	map2= e1.getValue();
        	set2 = map2.entrySet();
        	sizeSet2=0;
        	for (Entry<String, Float> e2 : set2) {
        		sizeSet2=sizeSet2+e2.getValue();
        	}
   		
        	for (Entry<String, Float> e2 : set2) {
	       terme = e2.getKey();
	       IDF= calculIDF.calculIdf(mapOfMap,terme); //caldul de ti
	       TF = e2.getValue()/sizeSet2;
	       wij=TF*IDF;
	       e2.setValue(wij);
	   }
	}
		return mapOfMap;
	}
}
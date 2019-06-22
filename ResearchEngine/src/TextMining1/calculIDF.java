package TextMining1;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class calculIDF {
	public static float calculIdf(HashMap<File, HashMap<String,Float>> map, String mot)
 {
		float ti=0; //Nombre de documents ou le terme ti apparait
        Set<Entry<File, HashMap<String, Float>>> set1 = map.entrySet();
        float D=set1.size(); // D le nombre total des docs dans le corpus
        for (Entry<File, HashMap<String, Float>> e1 : set1) {            
            Map<String, Float> map2 = e1.getValue();
            for (String  e2 : map2.keySet()) {
            	if (e2.equals(mot)) {
            		ti+=1;
            		continue;
            	}
            	            }
            
        }
        float IDF= (float)Math.log((float)D/(float)ti);
        return IDF ;

	}
}
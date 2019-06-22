package TextMining1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.python.modules.math;

public class cosinus {
	public static Map<File, Float> cos(HashMap<File, HashMap<String,Float>> mapOfMap, Map<String, Float> frequencyQuery){
	 Set<Entry<String, Float>> QUERY = frequencyQuery.entrySet();
     float size=QUERY.size();// D le nombre total des docs dans le corpus
     ArrayList<Float> d= new ArrayList<Float>();
		 ArrayList<Float> d1=new ArrayList<Float>();
	 Map<File, Float> cos=new HashMap<File, Float>();

        for (Entry<String, Float> e2 : QUERY) {
            e2.setValue(e2.getValue()/size);
        }
        
		for (File doc : mapOfMap.keySet())
		{
			for(String word :frequencyQuery.keySet())
			{
				d.add(frequencyQuery.get(word));
			
				if(mapOfMap.get(doc).containsKey(word))
					{
					
						d1.add(mapOfMap.get(doc).get(word));
							
					}
				else
					{
						d1.add((float) 0);
					}
			}
			
			Float d_d1=(float) 0,sum_d = (float) 0,sum_d1=(float) 0;
			for(int i=0;i<d1.size();i++)
			{
				d_d1+=d1.get(i)*d.get(i);
				sum_d+=d.get(i)*d.get(i);
				sum_d1+=d1.get(i)*d1.get(i);
			}
			if(sum_d==0 || sum_d1 ==0) {
    			cos.put(doc,(float) 0);
			}else {
    			cos.put(doc,(float) (d_d1/((math.sqrt(sum_d))*(math.sqrt(sum_d1)))));
			}
			d.clear();
			d1.clear();
		}
		return cos;
	}
}
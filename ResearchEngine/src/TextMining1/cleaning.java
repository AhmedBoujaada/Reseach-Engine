package TextMining1;
import java.util.ArrayList;

public class cleaning {
	public static ArrayList<String> clean(ArrayList<String> list){
		for (int i=0;i<list.size(); i++) {
    		list.set(i, list.get(i).replaceAll("[^أ-ي]", ""));
    		list.set(i, list.get(i).replaceAll("\\s", ""));        
    	}
    	
		while(list.remove(""));

    	
	return list;
	
	}

	
}


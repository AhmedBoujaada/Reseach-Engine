package TextMining1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFileAsArraylist {
	public static ArrayList<String> readFile(File file) throws FileNotFoundException{
        	Scanner s2 = new Scanner(file);
        	ArrayList<String> list = new ArrayList<String>();
        	while (s2.hasNext()){
        		list.add(s2.next());
        	}
        	s2.close();
			return list;
		
		
	}
}
package TextMining1;
import java.util.List;

import safar.basic.morphology.stemmer.factory.StemmerFactory;
import safar.basic.morphology.stemmer.interfaces.IStemmer;
import safar.basic.morphology.stemmer.model.WordStemmerAnalysis;

public class stemming {
            //Stemming  

			static  IStemmer stemmer= StemmerFactory.getKhojaImplementation();
  			static String stem;

			public static String StemmingFunction(String text) {
	            List<WordStemmerAnalysis> listResult= stemmer.stem(text);
                    	stem= listResult.get(0).getListStemmerAnalysis().get(0).getMorpheme();
                    		return stem;
			}
			}
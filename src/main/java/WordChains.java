import algorithms.AlgorithmWithMap;
import logic.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reader.ReadDataFromFile;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


public class WordChains {
    final static Logger logger = LoggerFactory.getLogger(WordChains.class);
    final static String TAG= WordChains.class.getName();
    public static void main(String[] args) {
        logger.info(TAG+" Start WordChains");
        long t0 = System.nanoTime();
        Manager manager=new Manager();
        logger.info(TAG+" Args "+ Arrays.stream(args).collect(Collectors.toList()));
        manager.setWords(args);
        if(manager.checkLengthWords()) {
            Collection result=manager.getResult(manager.getWordsData(new ReadDataFromFile(), args[2]),new AlgorithmWithMap());
            if(result!=null)
                result
                    .stream()
                    .forEach(System.out::println);
        }
        else {
            logger.error(TAG+" Words have different length");
            System.out.println("Words must be this same length");
        }
        long t1 = System.nanoTime();
        System.out.println("Elapsed time =" + (t1 - t0)/1000000000.0
                + " seconds");
        logger.info(TAG+" End WordChains");
    }
}

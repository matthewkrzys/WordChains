import logic.Manager;
import reader.ReadDataFromFile;
import reader.Reader;

import java.util.List;

public class WordChains {
    public static void main(String[] args) {
        long t0 = System.nanoTime();
        Manager manager=new Manager();
        manager.setWords(args);
        if(manager.checkLengthWords()) {
            System.out.println(manager.getWordsData(new ReadDataFromFile(), args[2]));
        }
        else {
            System.out.println("Words must be this same length");
        }
        long t1 = System.nanoTime();
        System.out.println("Elapsed time =" + (t1 - t0)/1000000000.0
                + " seconds");
    }
}

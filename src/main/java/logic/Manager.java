package logic;

import algorithms.Algorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reader.Reader;
import java.util.Collection;

public class Manager {
    final static Logger logger = LoggerFactory.getLogger(Manager.class);
    final static String TAG= Manager.class.getName();

    private StringBuilder firstWord;
    private StringBuilder secondWord;

    public void setWords(String[] args){
        firstWord=new StringBuilder(args[0]);
        logger.info(TAG+" Insert firstWord "+args[0]);
        secondWord=new StringBuilder(args[1]);
        logger.info(TAG+" Insert secondWord "+args[1]);
    }
    public Collection getWordsData(Reader reader, String path){
        logger.info(TAG+" Path "+path);
        return reader.readData(path,firstWord.length());
    }

    public boolean checkLengthWords(){
        return firstWord.length()==secondWord.length();
    }
    public Collection getResult(Collection collection, Algorithm algorithm){
        algorithm.setDictionary(collection);
        return algorithm.getResult(firstWord,secondWord);
    }
}

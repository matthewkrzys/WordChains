package algorithms;

import model.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AlgorithmWithMap implements Algorithm {
    final static Logger logger = LoggerFactory.getLogger(AlgorithmWithMap.class);
    final static String TAG= AlgorithmWithMap.class.getName();

    private Collection dictionary;
    private Word word;
    @Override
    public void setDictionary(Collection collection) {
        dictionary=collection;
    }

    @Override
    public Collection getResult(StringBuilder firstWord, StringBuilder secondWord) {
        logger.info(TAG+" firstWord "+firstWord+" secondWord "+secondWord);
        createModel(firstWord);
        return findResultWords(firstWord,secondWord);
    }

    public Collection getDictionary() {
        return dictionary;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    private Collection findResultWords(StringBuilder firstWord, StringBuilder secondWord){
        List<String> listResult=new ArrayList<>();
        int counterSetChar=0;
        int counterChar=1;
        StringBuilder currentWord=new StringBuilder(firstWord);
        logger.info(TAG+" currentWord "+currentWord);
        StringBuilder lastGoogWord=new StringBuilder(firstWord);
        logger.info(TAG+" lastGoodWord "+lastGoogWord);
        listResult.add(firstWord.toString());
        while(counterSetChar!=firstWord.length()){
            logger.info(TAG+" counterSetChar "+counterSetChar);
            if (word.getCheckCharInWord()[counterChar])
                counterChar=(counterChar+1)%firstWord.length();
            else {
                currentWord.setCharAt(counterChar, secondWord.charAt(counterChar));
                if (dictionary.contains(currentWord.toString())&&!listResult.contains(currentWord.toString())) {
                    logger.info(TAG+" word "+counterChar+ " is in dictionary");
                    word.getCheckCharInWord()[counterChar] = true;
                    counterChar = 1;
                    counterSetChar++;
                    lastGoogWord.replace(0,currentWord.length(),currentWord.toString());
                    logger.info(TAG+" lastGoodWord "+lastGoogWord);
                    listResult.add(lastGoogWord.toString());
                    if(lastGoogWord.toString().equals(secondWord.toString())){
                        break;
                    }
                } else {
                    logger.info(TAG+" word "+counterChar+ " is not in dictionary");
                    counterChar = (counterChar + 1) % firstWord.length();
                    currentWord.replace(0,lastGoogWord.length(),lastGoogWord.toString());
                }
            }
        }
        return listResult;

    }

    private void createModel(StringBuilder firstWord){
        word=new Word(firstWord);
    }
}

package logic;

import reader.Reader;
import java.util.Collection;

public class Manager {

    private String firstWord;
    private String secondWord;

    public void setWords(String[] args){
        firstWord=args[0];
        secondWord=args[1];
    }
    public Collection getWordsData(Reader reader, String path){
        return reader.readData(path,firstWord.length());
    }

    public boolean checkLengthWords(){
        return firstWord.length()==secondWord.length();
    }
    public Collection getResult(Collection collection){
        return null;
    }
}

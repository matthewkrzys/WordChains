package model;

public class Word {
    private StringBuilder word;
    private boolean[] checkCharInWord;

    public Word(StringBuilder word){
        this.word=word;
        checkCharInWord= new boolean[word.length()];
    }

    public StringBuilder getWord() {
        return word;
    }

    public void setWord(StringBuilder word) {
        this.word = word;
    }

    public boolean[] getCheckCharInWord() {
        return checkCharInWord;
    }

    public void setCheckCharInWord(boolean[] checkCharInWord) {
        this.checkCharInWord = checkCharInWord;
    }
}

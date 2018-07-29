import model.Word;
import org.junit.Assert;
import org.junit.Test;


public class WordTest {

    Word word;
    @Test
    public void CreateWord(){
        StringBuilder testWord=new StringBuilder("log");
        word=new Word(testWord);
        Assert.assertTrue(!word.getWord().toString().isEmpty());
        Assert.assertTrue(word.getCheckCharInWord()!=null);
        Assert.assertTrue(word.getWord().toString().length()==word.getCheckCharInWord().length);
        Assert.assertTrue((word.getCheckCharInWord()[0]&&word.getCheckCharInWord()[1]&&word.getCheckCharInWord()[2])==false);
    }
}

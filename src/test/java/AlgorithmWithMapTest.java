import algorithms.AlgorithmWithMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AlgorithmWithMapTest {

    Collection collection;
    AlgorithmWithMap algorithmWithMap;
    StringBuilder firstWord;
    StringBuilder secondWord;
    @Before
    public void runBefore(){
        algorithmWithMap=new AlgorithmWithMap();
        collection=new ArrayList();
        collection.add("cat");
        collection.add("dog");
        collection.add("cot");
        collection.add("cog");
        collection.add("fog");
        collection.add("log");

        firstWord=new StringBuilder("cat");
        secondWord=new StringBuilder("dog");
    }
    @Test
    public void setDictionaryTest(){
        algorithmWithMap.setDictionary(collection);
        Assert.assertTrue(algorithmWithMap.getDictionary().containsAll(collection));
    }
    @Test
    public void getResultTest(){
        algorithmWithMap.setDictionary(collection);
        List<String> listResult= (List<String>) algorithmWithMap.getResult(firstWord,secondWord);
        Assert.assertTrue(listResult.containsAll(Arrays.asList("cat","cot","cog","dog")));
    }
}

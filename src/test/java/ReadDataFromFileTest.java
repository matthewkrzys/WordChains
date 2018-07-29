import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import reader.ReadDataFromFile;

import java.util.ArrayList;
import java.util.Collection;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReadDataFromFileTest {
    Collection collection;
    @Mock
    ReadDataFromFile readDataFromFile;
    @Before
    public void runBefore(){
        collection=new ArrayList();
        collection.add("cat");
        collection.add("dog");
        collection.add("cot");
        collection.add("cog");
        collection.add("fog");
        collection.add("log");
    }
    @Test
    public void readDataTest(){
        when(readDataFromFile.readData(any(String.class),any(Long.class))).thenReturn(collection);
        Collection result=readDataFromFile.readData("wordlist.txt",7);
        Assert.assertTrue(result.containsAll(collection));
    }
}

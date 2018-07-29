import logic.Manager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reader.ReadDataFromFile;
import reader.Reader;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ManagerTest {

    @Mock
    Reader reader;

    Collection collection;
    Manager manager;
    @Before
    public void beforeTests(){
        manager=new Manager();
        collection=new ArrayList();
        collection.add("cat");
        collection.add("dog");
        collection.add("cot");
        collection.add("cog");
        collection.add("fog");
        collection.add("log");
    }
    @Test
    public void checkLengthWords_GoodLength_Test(){
        manager.setWords(new String[]{"cat","dog"});
        Assert.assertTrue(manager.checkLengthWords());
    }

    @Test
    public void checkLengthWords_BadLength_Test(){
        manager.setWords(new String[]{"cats","dog"});
        Assert.assertFalse(manager.checkLengthWords());
    }
    @Test
    public void getWordsData_Test(){
        when(reader.readData(any(String.class),any(Long.class))).thenReturn(collection);
        manager.setWords(new String[]{"cats","dog"});
        Collection result=manager.getWordsData(reader,"wordlist.txt");
        Assert.assertTrue(result.containsAll(collection));
    }
}

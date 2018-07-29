package reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ReadDataFromFile implements Reader {
    final static Logger logger = LoggerFactory.getLogger(ReadDataFromFile.class);
    final static String TAG= ReadDataFromFile.class.getName();

    @Override
    public Collection readData(String path, long lengthWord) {
        logger.info(TAG+" Path "+path+" lengthWord "+lengthWord);
        return readFile(path,lengthWord);
    }

    public Collection readFile(String path, long length){
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            list = br.lines().filter((s)->s.length()==length).collect(Collectors.toList());
            logger.info(TAG+" File was readed");
        } catch (IOException e) {
            logger.info(TAG+" Problem with read file "+e.getMessage());
            e.printStackTrace();
        }
        return list;

    }
}

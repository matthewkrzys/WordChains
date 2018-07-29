package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ReadDataFromFile implements Reader {

    @Override
    public Collection readData(String path, long lengthWord) {
        return readFile(path,lengthWord);
    }

    private Collection readFile(String path,long length){
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            list = br.lines().filter((s)->s.length()==length).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
}

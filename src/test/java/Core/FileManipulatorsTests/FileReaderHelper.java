package Core.FileManipulatorsTests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderHelper {

    public List<String> extractData(File file) {
        List<String> gameData = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                gameData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameData;
    }

}

package Core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccessor {

    private OutputStream outputStream;

    public FileAccessor(String pathName) {
        File gameData = new File(pathName);
        try {
            outputStream = new FileOutputStream(gameData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeGameValue(String gameValue) {
        String valueNewLine = gameValue + "\n";
        try {
            outputStream.write(valueNewLine.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> performExtraction(String pathName) {
        File file = new File(pathName);
        List<String> gameMoves = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                gameMoves.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gameMoves;
    }
}

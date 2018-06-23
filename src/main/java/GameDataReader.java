import java.io.*;
import java.util.ArrayList;

public class GameDataReader {

    public ArrayList<String> readThis(File file) {
        ArrayList<String> gameData = new ArrayList<>();

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

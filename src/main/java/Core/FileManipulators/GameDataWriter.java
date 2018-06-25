package Core.FileManipulators;

import java.io.*;

public class GameDataWriter {

    private File gameData;

    public GameDataWriter() {
        gameData = new File("src/main/resources/gameData.txt");
    }

    public void writeGameValue(String gameValue) {
        String gameValuePlusNewLine = gameValue + "\n";
        try {
            OutputStream outputStream = new FileOutputStream(gameData);
            outputStream.write(gameValuePlusNewLine.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public File getGameData() {
        return gameData;
    }
}

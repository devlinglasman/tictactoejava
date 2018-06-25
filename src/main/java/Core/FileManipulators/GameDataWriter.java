package Core.FileManipulators;

import java.io.*;

public class GameDataWriter {

    private File gameData;
    private OutputStream outputStream;

    public GameDataWriter() {
        gameData = new File("src/main/resources/gameData.txt");
        assignOutputStream();
    }

    public void writeGameValue(String gameValue) {
        String gameValuePlusNewLine = gameValue + "\n";
        try {
            outputStream.write(gameValuePlusNewLine.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public File getGameData() {
        return gameData;
    }

    private void assignOutputStream() {
        try {
            outputStream = new FileOutputStream(gameData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

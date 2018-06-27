package Core.FileManipulators;

import java.io.*;

public class GameDataWriter {

    private OutputStream outputStream;
    private File gameData;

    public GameDataWriter() {
        outputStream = null;
        gameData = null;
    }

    public void createFile(){
        gameData = new File("src/main/resources/gameData.txt");
        try {
            outputStream = new FileOutputStream(gameData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
}

package Core.FileManipulators;

import java.io.*;

public class GameDataWriter {

    private OutputStream outputStream;
    private File gameData;

    public GameDataWriter() {
        outputStream = null;
        gameData = null;
    }

    public void createFile(String pathName){
        gameData = new File(pathName);
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

    public File getGameData() {
        return gameData;
    }
}

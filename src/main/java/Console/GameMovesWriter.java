package Console;

import Core.Game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GameMovesWriter {

    File gameValues;
    OutputStream outputStream;
    GameMovesReader gameMovesReader;

    public GameMovesWriter() throws IOException {
        gameValues = new File("pathGameValues");
        gameMovesReader = new GameMovesReader();
        outputStream = new FileOutputStream(gameValues);
    }

    public void writeValue(String value) throws IOException {
        String valuePlusNewLine = value + "\n";
        outputStream.write(valuePlusNewLine.getBytes());
    }

    public File getGameValues() {
        return gameValues;
    }
}

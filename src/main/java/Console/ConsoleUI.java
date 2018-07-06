package Console;

import Core.Board.Grid;
import Core.Board.Mark;
import Core.UserInterfaces.UI;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UI {

    private final Scanner scanner;
    private final PrintStream out;
    private int pauseLength;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BRIGHTBLACK = "\u001B[90m";
    public static final String ANSI_BRIGHTWHITE = "\u001B[37m";
    public static final String ANSI_BRIGHTRED = "\u001B[91m";
    public static final String ANSI_BRIGHTGREEN = "\u001B[92m";
    public static final String ANSI_BRIGHTYELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHTBLUE = "\u001B[94m";
    public static final String ANSI_BRIGHTPURPLE = "\u001B[95m";

    public ConsoleUI(InputStream in, PrintStream out, int pauseLength) {
        this.scanner = new Scanner(in);
        this.out = out;
        this.pauseLength = pauseLength;
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void presentMessage(String message) {
        out.print(message);
    }

    @Override
    public void displayGrid(Grid grid) {
        List<Mark> squares = grid.getSquares();
        StringBuilder displayedGrid = new StringBuilder();

        out.println();
        for (int i = 0; i < squares.size(); i++) {
            StringBuilder tile = makeTile(squares.get(i), i);
            displayedGrid.append(tile);
            if (i < 9) {
                displayedGrid.append(" ");
            }
            if ((i + 1) % grid.getGridSize() == 0) {
                displayedGrid.append("\n");
            }
        }
        out.print(displayedGrid);
    }

    @Override
    public void pause() {
        try {
            Thread.sleep(pauseLength);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }

    private StringBuilder makeTile(Mark mark, int index) {
        StringBuilder finalColour = findColour(mark);
        StringBuilder symbol = findSymbol(mark, index);
        return new StringBuilder(finalColour + "[" + symbol + "]" + ANSI_RESET);
    }

    private StringBuilder findColour(Mark mark) {
        if (mark == Mark.EMPTY) {
            return new StringBuilder(ANSI_BRIGHTPURPLE);
        } else if (mark == Mark.PLAYER_ONE) {
            return new StringBuilder(ANSI_BRIGHTBLACK);
        } else {
            return new StringBuilder(ANSI_BRIGHTWHITE);
        }
    }

    private StringBuilder findSymbol(Mark mark, int index) {
        if (mark == Mark.EMPTY) {
            index++;
            return new StringBuilder(Integer.toString(index));
        } else {
            return new StringBuilder(mark.getStringRepresentation());
        }
    }
}

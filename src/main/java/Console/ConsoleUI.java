package Console;

import Core.Mark;
import Core.UI;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
    public void displayGrid(ArrayList<Mark> squares) {
        ArrayList<String> gridConglomerator = new ArrayList<>();

        for (int i = 0; i < squares.size(); i++) {
            String colour;
            Mark mark = squares.get(i);
            String tile;

                switch (i) {
                    case 0:
                        colour = ANSI_BRIGHTYELLOW;
                        break;
                    case 1:
                        colour = ANSI_BRIGHTRED;
                        break;
                    case 2:
                        colour = ANSI_BRIGHTPURPLE;
                        break;
                    case 3:
                        colour = ANSI_BRIGHTRED;
                        break;
                    case 4:
                        colour = ANSI_BRIGHTPURPLE;
                        break;
                    case 5:
                        colour = ANSI_BRIGHTBLUE;
                        break;
                    case 6:
                        colour = ANSI_BRIGHTPURPLE;
                        break;
                    case 7:
                        colour = ANSI_BRIGHTBLUE;
                        break;
                    case 8:
                        colour = ANSI_BRIGHTGREEN;
                        break;
                    default:
                        colour = ANSI_BRIGHTBLACK;
                }

            tile = makeTile(mark, i, colour);
            gridConglomerator.add(tile);

            }

        gridConglomerator.add(3, "\n");
        gridConglomerator.add(7, "\n");

        StringBuilder gridFinal = new StringBuilder();

        for (String s : gridConglomerator) {
            gridFinal.append(s);
        }
        out.print("\n" + gridFinal + "\n");
    }

    private String makeTile(Mark mark, int index, String colour) {
        String finalColour = findColour(mark, colour);
        String symbol = findSymbol(mark, index);
        return finalColour + "[" + symbol + "]" + ANSI_RESET;
    }

    private String findColour(Mark mark, String colour) {
        if (mark == Mark.UNMARKEDSQUARE) {
            return colour;
        } else if (mark == Mark.PLAYERONEMARK) {
            return ANSI_BRIGHTBLACK;
        } else {
            return ANSI_BRIGHTWHITE;
        }
    }

    private String findSymbol(Mark mark, int index) {
        return mark == Mark.UNMARKEDSQUARE ? Integer.toString(index + 1) :
                mark.getStringRepresentation();
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
}

package Console;

import Core.Mark;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleIO {

    private final Scanner scanner;
    private final PrintStream out;
    private final ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BRIGHTBLACK = "\u001B[90m";
    public static final String ANSI_BRIGHTWHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BRIGHTRED = "\u001B[91m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BRIGHTGREEN = "\u001B[92m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BRIGHTYELLOW = "\u001B[93m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BRIGHTBLUE = "\u001B[94m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BRIGHTPURPLE = "\u001B[95m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BRIGHTCYAN = "\u001B[96m";

    public ConsoleIO(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public void displayGrid(ArrayList<Mark> squares) {
        ArrayList<String> gridConglomerator = new ArrayList<>();
        for (int i = 0; i < squares.size(); i++) {
            Mark squareMark = squares.get(i);
            if (squareMark == Mark.playerOneMark) {
                gridConglomerator.add(ANSI_BRIGHTBLACK + "[" + squareMark.getStringRepresentation() + "]" + ANSI_RESET);
            }
                else if (squareMark == Mark.playerTwoMark){
                gridConglomerator.add(ANSI_BRIGHTWHITE + "[" + squareMark.getStringRepresentation() + "]" + ANSI_RESET);
            } else {
                switch (i) {
                    case 0:
                        gridConglomerator.add(ANSI_BRIGHTYELLOW + "[1]" + ANSI_RESET);
                        break;
                    case 1:
                        gridConglomerator.add(ANSI_BRIGHTRED + "[2]" + ANSI_RESET);
                        break;
                    case 2:
                        gridConglomerator.add(ANSI_BRIGHTPURPLE + "[3]" + ANSI_RESET);
                        break;
                    case 3:
                        gridConglomerator.add(ANSI_BRIGHTRED + "[4]" + ANSI_RESET);
                        break;
                    case 4:
                        gridConglomerator.add(ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET);
                        break;
                    case 5:
                        gridConglomerator.add(ANSI_BRIGHTBLUE + "[6]" + ANSI_RESET);
                        break;
                    case 6:
                        gridConglomerator.add(ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET);
                        break;
                    case 7:
                        gridConglomerator.add(ANSI_BRIGHTBLUE + "[8]" + ANSI_RESET);
                        break;
                    case 8:
                        gridConglomerator.add(ANSI_BRIGHTGREEN + "[9]" + ANSI_RESET);
                        break;
                }
            }
        }
        gridConglomerator.add(3, "\n");
        gridConglomerator.add(7, "\n");

        StringBuilder gridFinal = new StringBuilder();

        for (String s : gridConglomerator) {
            gridFinal.append(s);
        }
        out.print("\n" + gridFinal + "\n");
    }

    public int requestValidSquareChoice(String name) {
        String input = takeInput();
        boolean inputIllegal = validatorConsoleInput.inputNotValidGridNumber(input);
        while (inputIllegal) {
            announceInputInvalid(name);
            input = takeInput();
            inputIllegal = validatorConsoleInput.inputNotValidGridNumber(input);
        }
        int inputConverted = Integer.parseInt(input);
        return inputConverted--;
    }

    public String takeInput() {
        return scanner.nextLine();
    }

    public void askGameMode() {
        out.print("\nHi! please enter '1' to " +
                "play against the computer, '2' to see computer-vs-computer," +
                " or '3' for human-vs-human.\n");
    }

    public void announceGameChoiceInvalid() {
        out.print("\nUhoh please make a valid choice, 1 or 2.\n");
    }

    public void askForSquareChoice(String playerName) {
        out.print("\n" + playerName + " please select a square from 1-9.\n");
    }

    public void announceInputInvalid(String playerName) {
        out.print("\nLooks like " + playerName + " made a boo-boo! Please enter a number from 1-9 that hasn't already been picked.\n");
    }

    public void announceSquareChoice(String playerName) {
        out.print("\n" + playerName + " picked...\n");
    }

    public void announceWinner(String playerName) {
        out.print("\nCongratulations " + playerName + " - You're the winner!\n");
    }

    public void announceGameTied() {
        out.print("\nLooks like the game was a tie!\n");
    }

    public void pause() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clearScreen() {
        this.out.print("\033[H\033[2J");
        out.flush();
    }
}

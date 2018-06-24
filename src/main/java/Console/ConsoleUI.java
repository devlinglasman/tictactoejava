package Console;

import Core.Grid;
import Core.Mark;
import Core.Players.Player;
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
    public void askGameMode() {
        out.print(Messages.askGameMode);
    }

    @Override
    public int getValidNumber() {
        String input = getInput();
        boolean inputNotNumber = checkIfInputNotNumber(input);
        while (inputNotNumber) {
            announceNumberNotValid();
            input = getInput();
            inputNotNumber = checkIfInputNotNumber(input);
        }
        return Integer.parseInt(input);
    }

    public void announceNumberNotValid() {
        out.print(Messages.announceNumberNotValid);
    }

    @Override
    public void announceGameModeChoiceInvalid() {
        out.print(Messages.announceGameModeChoiceInvalid);
    }

    @Override
    public void displayGrid(ArrayList<Mark> squares) {
        ArrayList<String> gridConglomerator = new ArrayList<>();

        for (int i = 0; i < squares.size(); i++) {
            Mark squareMark = squares.get(i);
            if (squareMark == Mark.PLAYERONEMARK) {
                gridConglomerator.add(ANSI_BRIGHTBLACK + "[" + squareMark.getStringRepresentation() + "]" + ANSI_RESET);
            } else if (squareMark == Mark.PLAYERTWOMARK) {
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

    @Override
    public void askSquareChoice(Player player) {
        out.print(Messages.askSquareChoice(player));
    }

    @Override
    public void announceSquareChoiceInvalid(Player player) {
        out.print(Messages.announceSquareChoiceInvalid(player));
    }

    @Override
    public void presentMove(Player player, Grid grid) {
        clearScreen();
        pause();
        announceSquareChoice(player);
        pause();
    }

    public void announceSquareChoice(Player player) {
        out.print(Messages.announceSquareChoice(player));
    }

    @Override
    public void announceTie() {
        out.print(Messages.announceTie);
    }

    @Override
    public void announceWinner(Player player) {
        out.print(Messages.announceWinner(player));
    }

    private boolean checkIfInputNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return true;
        }
        return false;
    }

    private void pause() {
        try {
            Thread.sleep(pauseLength);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }
}

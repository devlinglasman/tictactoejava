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
        out.print("\nHi! please enter '1' to " +
                "play against the computer, '2' to see computer-vs-computer," +
                " or '3' for human-vs-human.\n");
    }

    @Override
    public String findGameMode() {
        askGameMode();
        String gameChoice = getInput();
        boolean gameChoiceIllegal = gameChoiceNotValid(gameChoice);
        while (gameChoiceIllegal) {
            announceGameModeChoiceInvalid();
            askGameMode();
            gameChoice = getInput();
            gameChoiceIllegal = gameChoiceNotValid(gameChoice);
        }
        return gameChoice;
    }

    @Override
    public int getValidNumber(Player player) {
        String input = getInput();
        boolean inputNotNumber = checkIfInputNotNumber(input);
        while (inputNotNumber) {
            announceSquareChoiceInvalid(player);
            input = getInput();
            inputNotNumber = checkIfInputNotNumber(input);
        }
        return Integer.parseInt(input);
    }

    @Override
    public void announceGameModeChoiceInvalid() {
        out.print("\nUhoh please make a valid choice...\n");
    }

    @Override
    public void displayGrid(ArrayList<Mark> squares) {
        ArrayList<String> gridConglomerator = new ArrayList<>();

        for (int i = 0; i < squares.size(); i++) {
            Mark squareMark = squares.get(i);
            if (squareMark == Mark.playerOneMark) {
                gridConglomerator.add(ANSI_BRIGHTBLACK + "[" + squareMark.getStringRepresentation() + "]" + ANSI_RESET);
            } else if (squareMark == Mark.playerTwoMark) {
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
        out.print("\n" + player.getName() + " please select a square from 1-9.\n");
    }

    @Override
    public void announceSquareChoiceInvalid(Player player) {
        out.print("\nLooks like " + player.getName() + " made a boo-boo! Please enter a valid number that hasn't already been picked.\n");
    }

    @Override
    public void presentMove(Player player, Grid grid) {
        clearScreen();
        pause();
        announceSquareChoice(player);
        pause();
    }

    public void announceSquareChoice(Player player) {
        out.print("\n" + player.getName() + " picked...\n");
    }

    @Override
    public void announceTie() {
        out.print("\nLooks like the game was a tie!\n");
    }

    @Override
    public void announceWinner(Player player) {
        out.print("\nCongratulations " + player.getName() + " - You're the winner!\n");
    }

    private boolean gameChoiceNotValid(String gameChoice) {
        return checkIfInputNotNumber(gameChoice) || gameChoiceNotInRange(gameChoice);
    }

    private boolean gameChoiceNotInRange(String gameChoice) {
        int gameChoiceInt = Integer.parseInt(gameChoice);
        return gameChoiceInt < 1 || gameChoiceInt > 3;
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

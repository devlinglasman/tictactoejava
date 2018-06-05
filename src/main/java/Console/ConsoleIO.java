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

    public ConsoleIO(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public void displayGrid(ArrayList<Mark> squares) {
        ArrayList<String> gridConglomerator = new ArrayList<>();
        for (Mark squareMark : squares) {
            gridConglomerator.add("[" + squareMark.getStringRepresentation() + "]");
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
        return scanner.next();
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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clearScreen() {
        this.out.print("\033[H\033[2J");
        out.flush();
    }
}
